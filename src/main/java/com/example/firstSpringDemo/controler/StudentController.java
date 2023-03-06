package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class

StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;

    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id) {
        Student student = studentService.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "/getStudentByStudentName", method = RequestMethod.GET)
    public List<Student> getStudentByStudentName(@RequestParam String studentName) {
        List<Student> student = studentService.getStudentByStudentName(studentName);
        return student;
    }

    @RequestMapping(value = "/getBySchoolId", method = RequestMethod.GET)
    public List<Student> getStudentBySchoolId(@RequestParam Integer schoolId) {
        List<Student> student = studentService.getStudentBySchoolId(schoolId);
        return student;
    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<Student> getIsActive() {
        List<Student> student = studentService.getAllIsActive();
        return student;
    }

    @RequestMapping(value = "/getIsInActive", method = RequestMethod.GET)
    public List<Student> getIsInActive() {
        List<Student> student = studentService.getAllIsInActive();
        return student;
    }

    @RequestMapping(value = "/ getLatestRow", method = RequestMethod.GET)
    public List<Student> getLatestRow() {
        List<Student> student = studentService.getAllLastRow();
        return student;
    }



    @RequestMapping(value = "/getIsUpdated", method = RequestMethod.GET)
    public List<Student> getAllLatestUpdated() {
        List<Student> student = studentService.getAllLatestUpdated();
        return student;
    }

    @RequestMapping(value = "/getSchoolCreatedAfterDate" , method = RequestMethod.GET)
    public List<Student> getSchoolCreatedAfterDate(@RequestParam String createdData) throws ParseException {
        List<Student> student = studentService.getStudentAfterCreatedDate(createdData);
        return student;
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public void deleteById(Integer id) {
        studentService.deleteById(id);

    }



    @RequestMapping (value = "/setAllIsActiveFalse")
    public void setAllIsActive(){
        studentService.setAllIsActiveFalse();
    }

    @RequestMapping(value = "/setAllIsActiveFalseAfterCreatdDate")
    public void setAllIsActiveFalseAfterCreatdDate(@RequestParam String createdData) throws ParseException {
        studentService.getStudentAfterCreatedDate(createdData);

    }

    @RequestMapping(value = "/setAllIsActiveFalseByStudentName")
    public void setAllIsActiveFalseByStudentName(String studentName)  {
        studentService.setAllIsActiveFalseByStudentName(studentName);

    }





}
