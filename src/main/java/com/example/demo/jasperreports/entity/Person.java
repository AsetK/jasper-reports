package com.example.demo.jasperreports.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Person {
    @Id
    private int id;
    private String name;
    private int age;
}
