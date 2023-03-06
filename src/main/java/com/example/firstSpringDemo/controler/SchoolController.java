package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> Schools = schoolService.getAllSchools();
        return Schools;

    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id) {
        School school = schoolService.getSchoolById(id);
        return school;
    }

    @RequestMapping(value = "/getSchoolBySchoolName", method = RequestMethod.GET)
    public List<School> getSchoolBySchoolName(@RequestParam String schoolName) {
        List<School> school = schoolService.getSchoolBySchoolName(schoolName);
        return school;
    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<School> getIsActive() {
        List<School> school = schoolService.getAllIsActive();
        return school;
    }



    @RequestMapping(value = "/getIsInActive", method = RequestMethod.GET)
    public List<School> getIsInActive() {
        List<School> school = schoolService.getAllIsInActive();
        return school;
    }


    @RequestMapping(value = "/ getLatestRow", method = RequestMethod.GET)
    public List<School> getLatestRow() {
        List<School> school = schoolService.getAllLastRow();
        return school;
    }



    @RequestMapping(value = "/getIsUpdated", method = RequestMethod.GET)
    public List<School> getAllLatestUpdated() {
        List<School> school = schoolService.getAllLatestUpdated();
        return school;
    }

    @RequestMapping(value = "/getSchoolCreatedAfterDate" , method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String createdData) throws ParseException{
        List<School> school = schoolService.getSchoolAfterCreatedDate(createdData);
        return school;
    }


    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public void deleteById(Integer id) {
         schoolService.deleteById(id);

    }



    @RequestMapping (value = "/setAllIsActiveFalse")
    public void setAllIsActive(){
        schoolService.setAllIsActiveFalse();
    }

    @RequestMapping(value = "/setAllIsActiveFalseAfterCreatdDate")
    public void setAllIsActiveFalseAfterCreatdDate(@RequestParam String createdData) throws ParseException {
        schoolService.getSchoolAfterCreatedDate(createdData);

    }

    @RequestMapping(value = "/setAllIsActiveFalseBySchoolName")
    public void setAllIsActiveFalseBySchoolName(String schoolName)  {
        schoolService.setAllIsActiveFalseBySchoolName(schoolName);

    }




}
