package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Discipline;
import ru.students.entity.Estimate;
import ru.students.repository.DisciplineRepository;
import ru.students.repository.EstimateRepository;

@RestController
@RequestMapping(value = "discipline")
public class DisciplineController {

    @Autowired
    DisciplineRepository disciplineRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addDiscipline(@RequestBody Discipline discipline)  {
        disciplineRepository.save(discipline);
    }

}
