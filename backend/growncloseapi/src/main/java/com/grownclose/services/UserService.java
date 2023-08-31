package com.grownclose.services;

import com.grownclose.exceptions.ResourceNotFoundException;
import com.grownclose.models.User;
import com.grownclose.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public User FindByIdRepo(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("The user id "+userId+" doesn't exist."));

        return user;
    }

}