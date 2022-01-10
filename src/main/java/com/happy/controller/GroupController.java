package com.happy.controller;

import com.happy.model.Group;
import com.happy.model.GroupStudy;
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

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/getGroup")
    public Group takeGroup(){
        Group byId = groupRepository.findById(2);
        return byId;
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("content", "groupList");
        return "index";
    }

    @RequestMapping("/realList")
    public String realList(ModelMap model) {

        model.addAttribute("groups", realGroupList);
        model.addAttribute("content", "realGroupList");
        return "index";
    }

   /* private List<GroupStudy> getGroupList() {
        List<GroupStudy> groupList = new ArrayList<>();
        GroupStudy group1 = new GroupStudy();
        group1.setName("Яслі_1 - Малятко");
        group1.setNumber(25);
        groupList.add(group1);
        groupList.add(group1);
        // add other groups
        return groupList;
    }*/


    List<GroupStudy> realGroupList;
    { realGroupList = new ArrayList<>();
        GroupStudy group1 = new GroupStudy();
        group1.setName("Яслі_1 - Малятко");
        group1.setNumber(25);
        realGroupList.add(group1);
        realGroupList.add(group1);}


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        realGroupList.remove(id-1);// this logic is not correct, id doesn’t depend on index
        return "redirect:/group/list";
    }




}
