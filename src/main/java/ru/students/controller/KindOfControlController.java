package ru.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.KindOfControl;
import ru.students.entity.Plan;
import ru.students.repository.KindOfControlRepository;
import ru.students.repository.PlanRepository;

@RestController
@RequestMapping(value = "kindOfControl")
public class KindOfControlController {
    @Autowired
    KindOfControlRepository kindOfControlRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addKindOfControl(@RequestBody KindOfControl kindOfControl)  {
        kindOfControlRepository.save(kindOfControl);
    }
}
