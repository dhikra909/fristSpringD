package com.example.firstSpringDemo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String courseName;
    List<Mark> markList;

}
