package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "School/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> Schools = schoolService.getAllSchools();
        return Schools;

    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public List<School> getSchoolById(@RequestParam Integer id) {
        List<School> school = schoolService.getSchoolById(id);
        return school;
    }

    @RequestMapping(value = "school/getSchoolBySchoolName", method = RequestMethod.GET)
    public List<School> getSchoolBySchoolName(@RequestParam String schoolName) {
        List<School> school = schoolService.getSchoolBySchoolName(schoolName);
        return school;
    }




}
