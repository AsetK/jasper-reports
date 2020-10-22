package com.example.demo.jasperreports.repository;

import com.example.demo.jasperreports.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
