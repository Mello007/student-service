package ru.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Student;
import ru.students.repository.StudentRepository;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired StudentRepository studentRepository;


    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addStudent(@RequestBody Student student)  {
        studentRepository.save(student);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = "application/json")
    public void deleteStudent(@RequestBody Student student)  {
        studentRepository.delete(student);
    }




}
