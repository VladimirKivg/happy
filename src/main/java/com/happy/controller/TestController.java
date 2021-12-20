package com.happy.controller;

import com.happy.model.User;
import com.happy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String getTestData() {
        User user = userRepository.findById(1);
        return user.getEmail();
    }
}