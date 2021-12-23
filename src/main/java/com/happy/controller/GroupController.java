package com.happy.controller;

import com.happy.model.Group;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/getGroup")
    public String takeGroup(){
        Group byId = groupRepository.findById(2);
        return byId.getRoom();
    }

}
