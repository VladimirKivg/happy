package com.happy.controller;

import com.happy.model.Group;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/group")
public class GroupController {
    private static final List<Group> groupList = new ArrayList<>();
    private static final int Money = 25;
    private static final int Tabak = 28;

    static {
        Group group1 = new Group();
        group1.setId(Money - Tabak);
        group1.setRoom(1);
        Group group2 = new Group();
        group2.setId("Money - Tabak");
        group2.setRoom(28);
        groupList.add(group1);
        groupList.add(group2);
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        groupList.remove(id-1);// this logic is not correct, id doesn’t depend on index
        return "redirect:/group/list";
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {
        List<Group> groupList = getGroupList();
        model.addAttribute("groups", groupList);
        model.addAttribute("content", "groupList");
        return "index";
    }

    private List<Group> getGroupList() {
        List<Group> groupList = new ArrayList<>();
        Group group1 = new Group();
        group1.setRoom("Money - Tabak");
        group1.setId(25);
        groupList.add(group1);
        // add other groups
        return groupList;
    }



    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/getGroup")
    public Group takeGroup(){
        Group byId = groupRepository.findById(2);
        return byId;
    }

}
