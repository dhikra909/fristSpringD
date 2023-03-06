package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Repositores.Studentrepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Student getStudentById(Integer id) {
        Student student = studentrepositores.getStudentById(id);
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
    public List<Student> getAllIsActive() {
        List<Student> student = studentrepositores.getIsActive();
        return student;
    }

    public List<Student> getAllIsInActive() {
        List<Student> student = studentrepositores.getIsInActive();
        return student;
    }

    public List<Student> getAllLastRow() {
        List<Student> student = studentrepositores.getLatestRow();
        return student;
    }

    public List<Student> getAllLatestUpdated() {
        List<Student> student = studentrepositores.getLatestUpdated();
        return student;
    }

    public List<Student> getStudentAfterCreatedDate(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDataFromStringToDataFormat = formatter.parse(data);
        List<Student> student = studentrepositores.getStudentAfterCreatedDate(convertedDataFromStringToDataFormat);
        return student;
    }

    public void deleteById(Integer id){
        Student student = studentrepositores.getStudentById(id);
        student.setIsActive(false);
        studentrepositores.save(student);
    }


    public void setAllIsActiveFalse() {
        List<Student> student = studentrepositores.getAllStudents();
        for (Student s : student){
            s.setIsActive(false);
        }
        studentrepositores.saveAll(student);
    }

    public void setAllIsActiveFalseAfterCreatdDate(String creatdDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat( "yyyy_mm_dd");
        Date creatdDatee = formatter.parse(creatdDate);
        List<Student> student = studentrepositores.getStudentByCreatedDate(creatdDatee);
        for (Student s : student) {
            s.setIsActive(false);
        }
        studentrepositores.saveAll(student);
    }

    public void setAllIsActiveFalseByStudentName(String studentName) {
        List<Student> student = studentrepositores.geStudentByStudentName(studentName);
        for (Student s : student){
            s.setIsActive(false);
        }
        studentrepositores.saveAll(student);
    }









}