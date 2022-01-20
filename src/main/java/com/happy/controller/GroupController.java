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
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        GroupStudy group2 = new GroupStudy("gaga", 21);
        realGroupList.add(group1);
        realGroupList.add(new GroupStudy("gugu",12));
        realGroupList.add(group2);
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
        List<GroupStudy> collect = realGroupList.stream()
                .filter((groupStudy) -> groupStudy.getId() == id).collect(Collectors.toList());
        if (collect!=null) {

/*@PostMapping( "/addVariable") те саме що @RequestMapping(value = "/add",method = RequestMethod.POST)*/
    @PostMapping( "/addVariable")
    public String addVariable(GroupStudy groupStudy){
        realGroupList.add(groupStudy);
        return "redirect:/group/realList";
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(GroupStudy groupStudy){
        realGroupList.add(groupStudy);
        return "redirect:/group/realList";
    }




}
