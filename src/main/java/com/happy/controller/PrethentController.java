package com.happy.controller;

import com.happy.model.Prethent;
import com.happy.repository.PrethentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prethent")

public class PrethentController {
    @Autowired
    PrethentRepository prethentRepository;

    @GetMapping("/getPrethent")
    public void takePrethent(){
        Prethent prethent = prethentRepository.findById(1);
        return ;
    }
}
