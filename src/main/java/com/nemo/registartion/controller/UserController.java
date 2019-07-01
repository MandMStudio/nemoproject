package com.nemo.registartion.controller;

import com.nemo.registartion.entity.User;
import com.nemo.registartion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/register", params = {"name", "surname", "email", "username", "password"})
    public User addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
                        @RequestParam String username, @RequestParam String password){

        String encodedPassword = new BCryptPasswordEncoder().encode(password);

        User userToRegister = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .username(username)
                .password(encodedPassword)
                .build();

        User savedUSer = userRepository.save(userToRegister);
        return savedUSer;
    }
}
