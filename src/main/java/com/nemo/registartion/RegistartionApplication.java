package com.nemo.registartion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class RegistartionApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistartionApplication.class, args);
    }
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return  args -> {
          userRepository.save(new User("Makar"));
          userRepository.save(new User("Maksym"));
        };
    }
}

@RestController
class HelloController {
    private final UserRepository userRepository;

    HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Second Release!";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}

@Entity
class User {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface UserRepository extends CrudRepository<User, Long> {
}
