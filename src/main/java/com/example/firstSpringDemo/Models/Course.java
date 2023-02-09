package com.example.firstSpringDemo.Models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Course {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "course_name")
    String courseName;

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
