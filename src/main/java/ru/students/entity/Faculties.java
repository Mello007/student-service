package ru.students.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Faculties")
public class Faculties extends BaseEntity   {
    private String faculties;
}
