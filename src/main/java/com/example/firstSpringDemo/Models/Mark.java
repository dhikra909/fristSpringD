package com.example.firstSpringDemo.Models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Mark extends BaseEntity{

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    public Integer getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Integer obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    Integer obtainedMarks;

    String grade;


    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName ="id")
   Course course;
}



