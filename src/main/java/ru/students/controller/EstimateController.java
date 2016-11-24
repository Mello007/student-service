package ru.students.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.students.entity.Estimate;
import ru.students.entity.Specialty;
import ru.students.repository.EstimateRepository;
import ru.students.repository.SpecialtyRepository;

@RestController
@RequestMapping(value = "estimate")
public class EstimateController {

    @Autowired
    EstimateRepository estimateRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = "application/json")
    public void addEstimate(@RequestBody Estimate estimate)  {
        estimateRepository.save(estimate);
    }



}
