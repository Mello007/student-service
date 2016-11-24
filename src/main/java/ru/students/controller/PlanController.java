package ru.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Plan;
import ru.students.entity.Session;
import ru.students.repository.PlanRepository;
import ru.students.repository.SessionRepository;

@RestController
@RequestMapping(value = "plan")
public class PlanController {

    @Autowired
    PlanRepository planRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addPlan(@RequestBody Plan plan)  {
        planRepository.save(plan);
    }

}
