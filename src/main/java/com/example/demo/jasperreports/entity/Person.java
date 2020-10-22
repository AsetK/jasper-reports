package com.example.demo.jasperreports.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    private int id;
    private String name;
    private int age;
}
