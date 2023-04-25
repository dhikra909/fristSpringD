package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Services.ReportService;
import com.example.firstSpringDemo.Services.SchoolService;
import com.example.firstSpringDemo.Slack.SlackClient;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {

    @Autowired
    ReportService reportService;
    @Autowired
    SchoolService schoolService;

    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
        return schools;

    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer id) {
        School school = schoolService.getSchoolById(id);
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getIsActive().toString());
        slackClient.sendMessage(school.getCreatedData().toString());
        slackClient.sendMessage(school.getUpdatedData().toString());
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());

        return school;
    }

    @RequestMapping(value = "/getSchoolBySchoolName", method = RequestMethod.GET)
    public List<School> getSchoolBySchoolName(@RequestParam String schoolName) {
        List<School> school = schoolService.getSchoolBySchoolName(schoolName);
        for (School s : school) {
            slackClient.sendMessage(s.getName());
            slackClient.sendMessage(s.getIsActive().toString());
            slackClient.sendMessage(s.getCreatedData().toString());
            slackClient.sendMessage(s.getUpdatedData().toString());
        }
        return school;
    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<School>







    getIsActive() {
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


@RequestMapping(value = "report")
    public  String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
}

    @RequestMapping(value = "reportstudent")
    public  void studentrepositores() throws JRException, FileNotFoundException {
         reportService.studentrepositores();
    }





}
