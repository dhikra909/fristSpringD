package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Repositores.CourselRepository;
import com.example.firstSpringDemo.Repositores.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourselRepository courseRepository;

    public List<Course> getAllCourse() {
        return courseRepository.getAllCourses();
    }


    public Course getCourseById(Integer id) {
        Course course = courseRepository.getCourseById(id);
        return course;
    }

    public Course getCourseByCourseName(String courseName) {
        Course course = courseRepository.getCourseByCourseName(courseName);
        return course;
    }







}
