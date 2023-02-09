package com.example.firstSpringDemo.Models;

import javax.persistence.*;

@Entity
@Table(name = "my_Dataapi.Students")
public class Student {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@Column(name = "Student_name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    String rollNumber;





}
