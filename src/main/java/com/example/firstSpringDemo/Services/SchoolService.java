package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Repositores.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    public List<School> getAllLastRow() {
        List<School> school = schoolRepository.getLatestRow();
        return school;
    }

    public List<School> getAllLatestUpdated() {
        List<School> school = schoolRepository.getLatestUpdated();
        return school;
    }

    public List<School> getSchoolAfterCreatedDate(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDataFromStringToDataFormat = formatter.parse(data);
        List<School> school = schoolRepository.getSchoolCreatedAfterDate(convertedDataFromStringToDataFormat);
        return school;
    }


    public void deleteById(Integer id){
        School school = schoolRepository.getSchoolById(id);
        school.setIsActive(false);
        schoolRepository.save(school);
    }


    public void setAllIsActiveFalse() {
        List<School> school = schoolRepository.getAllSchools();
        for (School s : school){
            s.setIsActive(false);
        }
        schoolRepository.saveAll(school);
    }

    public void setAllIsActiveFalseAfterCreatdDate(String creatdDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat( "yyyy_mm_dd");
        Date creatdDatee = formatter.parse(creatdDate);
        List<School> school = schoolRepository.getSchoolByCreatedDate(creatdDatee);
        for (School s : school) {
            s.setIsActive(false);
        }
        schoolRepository.saveAll(school);
    }

    public void setAllIsActiveFalseBySchoolName(String schoolName) {
        List<School> school = schoolRepository.getSchoolBySchoolName(schoolName);
        for (School s : school){
            s.setIsActive(false);
        }
        schoolRepository.saveAll(school);
    }


    public StringBuilder formatSchoolObjectForSlack(School school){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: *" + school.getId() + "*\n");
        sb.append("School Name: *" + school.getName() + "*\n");
        sb.append("Is Active: *" + school.getIsActive() + "*\n");
        return sb;
    }

    public StringBuilder formatSchoolListForSlack(List<School> schools){
        StringBuilder mainStringBuilder = new StringBuilder();
        for (School schoolFromListOfSchools: schools) {
            mainStringBuilder.append(formatSchoolObjectForSlack(schoolFromListOfSchools));
            mainStringBuilder.append("\n");
        }
        return mainStringBuilder;
    }








}