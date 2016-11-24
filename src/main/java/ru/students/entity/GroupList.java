package ru.students.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "GroupList")
public class GroupList  extends BaseEntity{
    private String year;
    private String semester;
    private String numberOfGroup;
}
