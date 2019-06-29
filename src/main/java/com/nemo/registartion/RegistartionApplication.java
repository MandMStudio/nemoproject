package com.nemo.registartion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RegistartionApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistartionApplication.class, args);
    }

}

@RestController
class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Second Release!";
    }
}
