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


    public List<Course> getCourseById(Integer id) {
        List<Course> course = courseRepository.getCourseById(id);
        return course;
    }

    public List<Course> getCourseByCourseName(String courseName) {
        List<Course> course = courseRepository.getCourseByCourseName(courseName);
        return course;
    }

    public List<Course> getAllIsActive() {
        List<Course> course = courseRepository.getIsActive();
        return course;
    }

    public List<Course> getAllIsInActive() {
        List<Course> course = courseRepository.getIsInActive();
        return course;
    }

    public List<Course> getAllLastRow() {
        List<Course> course = courseRepository.getLatestRow();
        return course;
    }




}
