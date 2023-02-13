package com.example.firstSpringDemo.controler;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Services.CourseService;
import com.example.firstSpringDemo.Services.MarkService;
import com.example.firstSpringDemo.Services.SchoolService;
import com.example.firstSpringDemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Hicontroler {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "Student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students;

    }
    @Autowired
    MarkService markService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "Mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> mark = markService.getAllMarks();
        return mark;
    }

    @RequestMapping(value = "Course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourse() {
        List<Course> course = courseService.getAllCourse();
        return course;
    }



    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "School/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> Schools = schoolService.getAllSchools();
        return Schools;

    }

    @GetMapping(value = "hello")
    public String hellostudent() {
        return "Hello Student";
    }

    //        @RequestMapping(value = "School/getAll", method = RequestMethod.GET)
//        public School getAllSchoolsById(@RequestParam Integer id) {
//            School school = new School();
//            return school;
//
//        }
    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public List<School> getSchoolById(@RequestParam Integer id) {
        List<School> school = schoolService.getSchoolById(id);
        return school;
    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public List<Student> getStudentById(@RequestParam Integer id) {
        List<Student> student = studentService.getStudentById(id);
        return student;
    }


    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public List<Mark> getMarkById(@RequestParam Integer id) {
        List<Mark> mark = markService.getMarkById(id);
        return mark;
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public List<Course> getCourseById(@RequestParam Integer id) {
        List<Course> course = courseService.getCourseById(id);
        return course;
    }


//    @RequestMapping(value = "course/getByNames", method = RequestMethod.GET)
//    public Course getCourseByName (@RequestParam String name) {
//        Course course = courseService.getCourseByName(name);
//        return course;
//    }


    @RequestMapping(value = "school/getSchoolBySchoolName", method = RequestMethod.GET)
    public List<School> getSchoolBySchoolName(@RequestParam String schoolName) {
        List<School> school = schoolService.getSchoolBySchoolName(schoolName);
        return school;
    }

    @RequestMapping(value = "student/getStudentByStudentName", method = RequestMethod.GET)
    public List<Student> getStudentByStudentName(@RequestParam String studentName) {
        List<Student> student = studentService.getStudentByStudentName(studentName);
        return student;
    }


    @RequestMapping(value = "mark/getMarkByMarkgrade", method = RequestMethod.GET)
    public List<Mark> getMarkByMarkgrade(@RequestParam String markgrade) {
        List<Mark> mark = markService.getMarkByMarkGrade(markgrade);
        return mark;
    }

    @RequestMapping(value = "course/getCourseByCourseName", method = RequestMethod.GET)
    public List<Course> getCourseByCourseName(@RequestParam String courseName) {
        List<Course> course = courseService.getCourseByCourseName(courseName);
        return course;
    }






}
