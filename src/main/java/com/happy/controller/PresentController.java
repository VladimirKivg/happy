package com.happy.controller;

import com.happy.model.Present;
import com.happy.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/present")

public class PresentController {
    @Autowired
    PresentRepository presentRepository;

    @GetMapping("/getPresent")
    public void takePresent(){
        Present present = presentRepository.findById(1);
        return ;
    }
}
