package com.happy.controller;

import com.happy.model.Group;
import com.happy.model.GroupStudy;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;


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

    @RequestMapping("/nullList")
    public String nullList(ModelMap model) {

        model.addAttribute("groups", null);
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
        for (GroupStudy groupStudy:realGroupList){
            out.println(groupStudy.getId());
        }
        /*List<GroupStudy> collect =*/
        int x=id;
       realGroupList.stream().filter((groupStudy) ->  groupStudy.getId()==id).forEach(out::println);

       /* if (first!=null) {
            first.ifPresentOrElse(user2 -> out.println(user2), () -> out.println("пользователь не найден"));
            }

            realGroupList.remove(first.get());// this logic is not correct, id doesn’t depend on index
        // this logic now is correct :)*/
        return "redirect:/group/realList";
    }


    @RequestMapping("addGroups")
    public String addRealGroup(GroupStudy groupStudy, ModelMap modelMap, BindingResult bindingResult) {
        modelMap.addAttribute("group",groupStudy);
        modelMap.addAttribute("content", "createGroup");
        return "index";
    }

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
