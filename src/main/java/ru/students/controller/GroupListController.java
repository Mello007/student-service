package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.GroupList;
import ru.students.entity.Plan;
import ru.students.repository.GroupListRepository;
import ru.students.repository.PlanRepository;


@RestController
@RequestMapping(value = "groupList")
public class GroupListController {

    @Autowired
    GroupListRepository groupListRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addGroupList(@RequestBody GroupList groupList)  {
        groupListRepository.save(groupList);
    }
}
