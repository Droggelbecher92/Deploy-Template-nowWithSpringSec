package de.neuefische.backend.controller;


import de.neuefische.backend.model.MyUser;
import de.neuefische.backend.model.MyUserDto;
import de.neuefische.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public MyUser createUser(@RequestBody MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.createUser(user);
    }

    @GetMapping("/me")
    public ResponseEntity<MyUserDto> me(Principal principal) {
        MyUser byUsername = userService.findByUsername(principal.getName()).orElseThrow();
        Optional<MyUserDto> dto = Optional.of(MyUserDto.builder().username(byUsername.getUsername()).role(byUsername.getRole()).build());
        return ResponseEntity.of(dto);
    }



}