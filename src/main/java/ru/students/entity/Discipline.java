package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Discipline")
public class Discipline extends BaseEntity {
    private String discipline;
}
