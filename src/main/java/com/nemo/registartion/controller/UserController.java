package com.nemo.registartion.controller;

import com.nemo.registartion.pojo.User;
import com.nemo.registartion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/add", params = {"name", "surname"})
    public User addUser(@RequestParam String name, @RequestParam String surname){
        User newUser = new User(name,surname);
        User savedUSer = userRepository.save(newUser);
        return savedUSer;
    }
}
