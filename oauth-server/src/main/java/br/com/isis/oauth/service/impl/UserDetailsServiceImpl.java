package br.com.isis.oauth.service.impl;

import br.com.isis.oauth.data.UserData;
import br.com.isis.oauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by joao on 08/05/17.
 */

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserData userData;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userData.findByEmail(username);
        if (user.isPresent()){
            return user.get();
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
}
