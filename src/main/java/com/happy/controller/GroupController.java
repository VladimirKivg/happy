package com.happy.controller;

import com.happy.model.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    private static final List<Group> groupList = new ArrayList<>();
    static {
        Group group1 = new Group();
        group1.setRoom("Яслі_1 - Малятко");
        group1.setId(1);
        Group group2 = new Group();
        group2.setRoom("Яслі_2 - Дзвіночок");
        group2.setId(2);
        groupList.add(group1);
        groupList.add(group2);
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {
                model.addAttribute("groups", groupList);
        model.addAttribute("content", "groupList");
        return "index";
    }
    private List<Group> getGroupList() {
        List<Group> groupList = new ArrayList<>();
        Group group1 = new Group();
        group1.setRoom("Яслі_1 - Малятко");
        group1.setId(25);
        groupList.add(group1);
        // add other groups
        return groupList;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        groupList.remove(id-1);// this logic is not correct, id doesn’t depend on index
        return "redirect:/group/list";
    }


}
