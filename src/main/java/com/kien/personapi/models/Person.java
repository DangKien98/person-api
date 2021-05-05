package com.kien.personapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    private int age;

    private boolean alive;
}
