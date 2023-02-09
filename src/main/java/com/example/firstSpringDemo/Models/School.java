package com.example.firstSpringDemo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Student_name")
    String name ;

    @OneToMany
            @JoinColumn(referencedColumnName = "id")
    List<Student> student;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
@OneToMany
@JoinColumn(referencedColumnName ="id")
    List<Course> courses;
}
