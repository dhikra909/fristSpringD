package com.example.firstSpringDemo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Shoolstudent {
    public Shoolstudent(String schoolName, String studentName, String rollNumber) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }
    String schoolName;
    String studentName;
    String rollNumber;
}
