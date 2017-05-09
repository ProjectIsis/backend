package br.com.isis.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by joao on 08/05/17.
 */

@RestController
public class UserController {

    @GetMapping("user")
    public Principal principal(Principal principal){
        return principal;
    }
}
