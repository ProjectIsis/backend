package br.com.isis.oauth.data;

import br.com.isis.oauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by joao on 08/05/17.
 */

@Repository
public interface UserData extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
