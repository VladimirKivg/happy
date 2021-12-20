package com.example.springWebSpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class TestController {



    @GetMapping
    public String getTestData() {

        return "123";
    }
    @Autowired
CustomerRepository customerRepository;

    @GetMapping(value = "/1")
    public String getTestDataName() {
        Customer customer = customerRepository.findById(1);
        String name = customer.getName();
        return name;
    }
}