package de.neuefische.backend.service;

import de.neuefische.backend.model.MyUser;
import de.neuefische.backend.repo.UserRepo;
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

    public MyUser createUser(MyUser user) {
        return userRepo.save(user);
    }
}
