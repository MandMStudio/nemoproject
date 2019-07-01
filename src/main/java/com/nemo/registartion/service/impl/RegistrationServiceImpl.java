package com.nemo.registartion.service.impl;

import com.nemo.registartion.entity.User;
import com.nemo.registartion.repository.UserRepository;
import com.nemo.registartion.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
