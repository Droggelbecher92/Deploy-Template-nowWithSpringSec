package de.neuefische.backend.service;

import de.neuefische.backend.model.MyUser;
import de.neuefische.backend.repo.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<MyUser> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public ResponseEntity<MyUser> createUser(MyUser user) {
        if (userRepo.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body(MyUser.builder().build());
        }
        return ResponseEntity.ok(userRepo.save(user));
    }
}
