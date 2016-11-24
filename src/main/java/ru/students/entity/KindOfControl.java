package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "KindOfControl")
public class KindOfControl extends BaseEntity {
    private String kindOfControl;
}
