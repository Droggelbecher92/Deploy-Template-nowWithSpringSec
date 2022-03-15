package de.neuefische.backend.repo;

import de.neuefische.backend.model.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<MyUser,String> {

        Optional<MyUser> findByUsername(String username);


}
