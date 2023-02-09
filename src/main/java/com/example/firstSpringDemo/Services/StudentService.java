package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Repositores.Studentrepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentService {

    @Autowired
    Studentrepositores studentrepositores;
@GetMapping(value = "addStudent")
    public void addStudents(){

        Student student = new Student();
        student.setName("thikra");
        student.setRollNumber("1");
        studentrepositores.save(student);

    }
}
