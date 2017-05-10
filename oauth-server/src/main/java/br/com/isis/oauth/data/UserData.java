package br.com.isis.oauth.data;

import br.com.isis.oauth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by joao on 08/05/17.
 */

@Repository
public interface UserData extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
