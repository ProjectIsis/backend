package br.com.isis.oauth.controller;

import br.com.isis.oauth.data.UserData;
import br.com.isis.oauth.enumeration.Role;
import br.com.isis.oauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;

/**
 * Created by joao on 08/05/17.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired private UserData userData;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping
    public Principal principal(Principal principal) {
        return principal;
    }

    @PostMapping
    public User save(@RequestBody @Valid User user) {
        if (user.getId() == null) {

            if (this.userData.findByEmail(user.getEmail()).isPresent()){
                throw new RuntimeException("user already exists");
            }

            if (user.getRoles() == null || user.getRoles().isEmpty()){
                user.setRoles(Arrays.asList(Role.ROLE_USER));
            }

            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(this.userData.findOne(user.getId()).getPassword());
        }
        return this.userData.save(user);
    }

    @PostMapping("password")
    public void password(@RequestParam String passwordAnt,
                         @RequestParam String passwordNew,
                         @RequestParam String passwordConfirm,
                         Principal principal) {
        User user = this.userData.findByEmail(principal.getName()).get();

        if (bCryptPasswordEncoder.matches(passwordAnt, user.getPassword()) && passwordNew.equals(passwordConfirm)) {

            user.setPassword(bCryptPasswordEncoder.encode(passwordNew));
            this.userData.save(user);

        } else {
            throw new RuntimeException("wrong password");
        }
    }
}
