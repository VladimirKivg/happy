package com.happy.controller;

import com.happy.model.Group;
import com.happy.model.GroupStudy;
import com.happy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping(value = "/group")
public class GroupController {

    List<GroupStudy> realGroupList;
    { realGroupList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            realGroupList.add(new GroupStudy("new Group"+i,12+i));
        }
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


   /* @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(GroupStudy groupStudy){
        realGroupList.add(groupStudy);
        return "redirect:/group/realList";
    }*/

/**додаємо валідацію а так то все як в закоментованому*/
    @RequestMapping( value = "/add", method = RequestMethod.POST)
    public String add(@Valid GroupStudy groupStudy,BindingResult  result, ModelMap model) {

        if (result.hasErrors()) {

            model.addAttribute("group", groupStudy);
            model.addAttribute("content", "createGroup");
            return "index";
        }
        realGroupList.add(groupStudy);
        return "redirect:/group/realList";
    }




    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        GroupStudy group = getGroupStudy(id); // this logic is not correct, group has to be                        //                                    selected by it’s id.
        model.addAttribute("group", group);
        model.addAttribute("content", "updateGroup");
        return "index";
    }

    @RequestMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") int id, GroupStudy group,
                              BindingResult result, Model model) {
        realGroupList.get(realGroupList.indexOf(getGroupStudy(id))).setName(group.getName());
        realGroupList.get(realGroupList.indexOf(getGroupStudy(id))).setNumber(group.getNumber());
        return "redirect:/group/realList";
    }

    private GroupStudy getGroupStudy(int id){
        return realGroupList.stream().filter(groupStudy -> groupStudy.getId()==id).findFirst().get();
    }


}
