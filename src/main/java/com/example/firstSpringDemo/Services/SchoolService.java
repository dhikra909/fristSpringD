package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.Mark;
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


    public List<School> getSchoolById(Integer id) {
        List<School> school = schoolRepository.getSchoolById(id);
        return school;
    }

    public List<School> getSchoolBySchoolName(String schoolName) {
        List<School> school = schoolRepository.getSchoolBySchoolName(schoolName);
        return school;
    }

    public List<School> getAllIsActive() {
        List<School> school = schoolRepository.getIsActive();
        return school;
    }
    public List<School> getAllIsInActive() {
        List<School> school = schoolRepository.getIsInActive();
        return school;
    }






}