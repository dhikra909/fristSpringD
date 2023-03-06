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

import java.text.ParseException;
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
    public Course getCourseById(@RequestParam Integer id) {
        Course course = courseService.getCourseById(id);
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

    @RequestMapping(value = "/getLatestRow", method = RequestMethod.GET)
    public List<Course> getLatestRow() {
        List<Course> course = courseService.getAllLastRow();
        return course;
    }



    @RequestMapping(value = "/getIsUpdated", method = RequestMethod.GET)
    public List<Course> getAllLatestUpdated() {
        List<Course> course = courseService.getAllLatestUpdated();
        return course;
    }

    @RequestMapping(value = "/getcourseCreatedAfterDate" , method = RequestMethod.GET)
    public List<Course> getcourseCreatedAfterDate(@RequestParam String createdData) throws ParseException {
        List<Course> course = courseService.getcourseCreatedAfterDate(createdData);
        return course;
    }


    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public void deleteById(Integer id) {
        courseService.deleteById(id);

    }



    @RequestMapping (value = "/setAllIsActiveFalse")
    public void setAllIsActive(){
        courseService.setAllIsActiveFalse();
    }

    @RequestMapping(value = "/setAllIsActiveFalseAfterCreatdDate")
    public void setAllIsActiveFalseAfterCreatdDate(@RequestParam String createdData) throws ParseException {
        courseService.getcourseCreatedAfterDate(createdData);

    }


    @RequestMapping(value = "/setAllIsActiveFalseByCourseName")
    public void setAllIsActiveFalseByCourseName(String courseName)  {
        courseService.setAllIsActiveFalseByCourseName(courseName);

    }















//    @RequestMapping(value = "/getIsInActive", method = RequestMethod.GET)
//    public List<Course> getIsInActive() {
//        List<Course> course = courseService.getAllIsInActive();
//        return course;
//    }







}
