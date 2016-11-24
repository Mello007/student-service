package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity @Table(name = "Estimate")
public class Estimate extends BaseEntity {
    private String year;
    private String semester;
    private String student;
    private String discipline;
    private String estimate;
}
