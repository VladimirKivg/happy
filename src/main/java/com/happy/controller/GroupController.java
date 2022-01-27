package com.happy.controller;

import com.happy.model.Group;
import com.happy.model.StudyGroup;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/group")
public class GroupController {
    private static final List<StudyGroup> groupList = new ArrayList<>();

    static {
        for (int i = 0; i <10; i++) {
StudyGroup studyGroup=new StudyGroup("money"+i,10+ i);
groupList.add(studyGroup);
        }
    }


    @RequestMapping("/list")
    public String list(@org.jetbrains.annotations.NotNull ModelMap model) {

        model.addAttribute("groups", groupList);
        model.addAttribute("content", "studyGroupList");
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, ModelMap model) {
       for (StudyGroup study:groupList) {
           if (study.getId()==id){
               groupList.remove(study);
               break;
           }
       }
        return "redirect:/group/list";
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
    @RequestMapping("/add-group")
    public String addGroup(StudyGroup studyGroup, ModelMap model, BindingResult result) {
       model.addAttribute("group",studyGroup);
        model.addAttribute("content", "createGroup");
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid StudyGroup studyGroup, ModelMap model, BindingResult result) {
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            model.addAttribute("group",studyGroup);
            model.addAttribute("content", "createGroup");
            return "index";
        }

        groupList.add(studyGroup);// this logic is not correct, id has to be populated
        return "redirect:/group/list";
    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        int c=id;
        StudyGroup studyGroup = null;
        for (StudyGroup group : groupList) {
            if (group.getId() == id) {
                studyGroup=group;

            }
        }

        model.addAttribute("group", studyGroup);
        model.addAttribute("content", "updateGroup");

            return "index";
        }


    @RequestMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") int id, StudyGroup group,
                              BindingResult result, Model model) {
        System.out.println(id);
    StudyGroup studyGroup=new StudyGroup();
        for (StudyGroup groups : groupList) {
            if (groups.getId() == id) {
                studyGroup = groups;
                System.out.println(groupList.indexOf(groups));
                break;
            }
        }
        groupList.get(groupList.indexOf(studyGroup)).setName(group.getName());
        groupList.get(groupList.indexOf(studyGroup)).setNumber(group.getNumber());
        return "redirect:/group/list";
    }


    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/getGroup")
    public Group takeGroup(){
        Group byId = groupRepository.findById(2);
        return byId;
    }

}
