package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "Specialty")
public class Specialty extends BaseEntity{
    private String specialty;
    private String faculty;
}