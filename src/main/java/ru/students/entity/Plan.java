package ru.students.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Plan")
public class Plan extends BaseEntity {
    private String specialty;
    private String year;
    private String cours;
    private String discipline;
    private String countOfHours;
    private String kindOfControl;
}
