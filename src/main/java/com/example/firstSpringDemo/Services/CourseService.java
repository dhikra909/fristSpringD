package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Repositores.CourselRepository;
import com.example.firstSpringDemo.Repositores.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<Course> getAllLatestUpdated() {
        List<Course> course = courseRepository.getLatestUpdated();
        return course;
    }

    public List<Course> getcourseCreatedAfterDate(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDataFromStringToDataFormat = formatter.parse(data);
        List<Course> course = courseRepository.getCourseCreatedAfterDate(convertedDataFromStringToDataFormat);
        return course;
    }


    public void deleteById(Integer id){
        Course course = courseRepository.getCourseById(id);
        course.setIsActive(false);
        courseRepository.save(course);
    }


    public void setAllIsActiveFalse() {
        List<Course> course = courseRepository.getAllCourses();
        for (Course s : course){
            s.setIsActive(false);
        }
        courseRepository.saveAll(course);
    }

    public void setAllIsActiveFalseAfterCreatdDate(String creatdDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat( "yyyy_mm_dd");
        Date creatdDatee = formatter.parse(creatdDate);
        List<Course> course = courseRepository.getCourseByCreatedDate(creatdDatee);
        for (Course s : course) {
            s.setIsActive(false);
        }
        courseRepository.saveAll(course);
    }












}
