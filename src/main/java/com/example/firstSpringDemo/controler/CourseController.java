package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourse() {
        List<Course> course = courseService.getAllCourse();
        return course;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public List<Course> getCourseById(@RequestParam Integer id) {
        List<Course> course = courseService.getCourseById(id);
        return course;
    }

    @RequestMapping(value = "/getCourseByCourseName", method = RequestMethod.GET)
    public List<Course> getCourseByCourseName(@RequestParam String courseName) {
        List<Course> course = courseService.getCourseByCourseName(courseName);
        return course;
    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<Course> getIsActive() {
        List<Course> course = courseService.getAllIsActive();
        return course;
    }

    @RequestMapping(value = "/getIsInActive", method = RequestMethod.GET)
    public List<Course> getIsInActive() {
        List<Course> course = courseService.getAllIsInActive();
        return course;
    }





}
