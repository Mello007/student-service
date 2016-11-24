package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Specialty;
import ru.students.entity.Teacher;
import ru.students.repository.SpecialtyRepository;
import ru.students.repository.TeacherRepository;

@RestController
@RequestMapping(value = "specialty")
public class SpecialtyController {



    @Autowired
    SpecialtyRepository specialtyRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addSpecialty(@RequestBody Specialty specialty)  {
        specialtyRepository.save(specialty);
    }

}
