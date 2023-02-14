package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Repositores.Studentrepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
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

    public List<Student> getAllStudents() {
        return studentrepositores.getAllStudents();
    }

    public List<Student> getStudentById(Integer id) {
        List<Student> student = studentrepositores.getStudentById(id);
        return student;
    }

    public List<Student> getStudentByStudentName(String studentName) {
        List<Student> student = studentrepositores.geStudentByStudentName(studentName);
        return student;
    }

    public List<Student> getStudentBySchoolId(Integer schoolId) {
        List<Student> student = studentrepositores.geStudentBySchoolId(schoolId);
        return student;
    }





}