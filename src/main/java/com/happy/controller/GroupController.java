package com.happy.controller;

import com.happy.model.Group;
import com.happy.pojo.PeopleToGroup;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/group")
public class GroupController  {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/getGroup")
    public Group takeGroup(){
        Group byId = groupRepository.findById(2);
        return byId;
    }
    @RequestMapping("/creation_email")
    public String root(Locale locale, ModelMap model) {
        model.addAttribute("content", "creation_email");
        return "index";
    }

    List<PeopleToGroup> peopleList = new ArrayList<>();

    @RequestMapping(value = "/listPeopleToGroup")
    public String listPeopleToGroup( ModelMap model) {

        peopleList.add(new PeopleToGroup("somebody","somebody@gmail.com"));
        model.addAttribute("listPeople",peopleList);
        model.addAttribute("content","showListPeople");
        return "index";
    }
}
