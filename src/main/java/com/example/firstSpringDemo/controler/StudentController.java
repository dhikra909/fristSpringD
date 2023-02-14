package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "Student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;

    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public List<Student> getStudentById(@RequestParam Integer id) {
        List<Student> student = studentService.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "student/getStudentByStudentName", method = RequestMethod.GET)
    public List<Student> getStudentByStudentName(@RequestParam String studentName) {
        List<Student> student = studentService.getStudentByStudentName(studentName);
        return student;
    }

    @RequestMapping(value = "student/getBySchoolId", method = RequestMethod.GET)
    public List<Student> getStudentBySchoolId(@RequestParam Integer schoolId) {
        List<Student> student = studentService.getStudentBySchoolId(schoolId);
        return student;
    }
}
