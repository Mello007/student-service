package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Faculties;
import ru.students.entity.GroupList;
import ru.students.repository.FacultiesRepository;
import ru.students.repository.GroupListRepository;

@RestController
@RequestMapping(value = "faculties")
public class FacultiesController {

    @Autowired
    FacultiesRepository facultiesRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addFaculties(@RequestBody Faculties faculties)  {
        facultiesRepository.save(faculties);
    }
}
