package com.happy.controller;

import com.happy.model.Group;
import com.happy.model.GroupP;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
 //створення групи
@RequestMapping(value = "/group")
public class GroupController {
    private static final List<GroupP> groupList = new ArrayList<>();
    static {
        GroupP group1 = new GroupP();
        group1.setName("Яслі_1 - Малятко");
        GroupP group2 = new GroupP();
        group2.setName("Яслі_2 - Дзвіночок");
        groupList.add(group1);
        groupList.add(group2);
        /*for (int i = 0; i < 10; i++) {
            GroupP groupP = new GroupP();
            groupP.setName("ukjj"+i);
            groupList.add(groupP);
        }*/
    }

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/getGroup")
    public Group takeGroup(){
        Group byId = groupRepository.findById(2);
        return byId;
    }
    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("groups",  groupList);
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

    //видалення за id групи
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
       /* for (GroupP groupP:groupList){
            System.out.println(groupP.getId());
        }*/
        Optional<GroupP> first = groupList.stream().filter(groupP -> groupP.getId() == id).findFirst();
        groupList.remove(first.get());// this logic is not correct, id doesn’t depend on index
        return "redirect:/group/list";
    }
    //редагування групи, доробити
    @RequestMapping("/add-group")
    public String addGroup(GroupP group, ModelMap model, BindingResult result) {
        model.addAttribute("content", "createGroup");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(GroupP group) {
        groupList.add(group);// this logic is not correct, id has to be populated
        return "redirect:/group/list";
    }

}
