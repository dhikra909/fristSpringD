package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Repositores.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }


    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getSchoolBySchoolName(String schoolName) {
        School school = schoolRepository.getSchoolBySchoolName(schoolName);
        return school;
    }









}