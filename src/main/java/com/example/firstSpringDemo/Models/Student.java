package com.example.firstSpringDemo.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity

public class Student extends BaseEntity {

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
//@OneToMany
//@JoinColumn(referencedColumnName ="id")
//List<Student> students;
    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName ="id")
    School school;


}
