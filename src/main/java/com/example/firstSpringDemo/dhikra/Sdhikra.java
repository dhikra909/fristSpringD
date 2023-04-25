package com.example.firstSpringDemo.dhikra;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Services.SchoolService;
import com.example.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class Sdhikra {

    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;

    @Scheduled (cron = "*/5 * * * * *")
    public List<School> getSchoolBySchoolName() {
        List<School> school = schoolService.getAllSchools();
        for (School s : school) {
            slackClient.sendMessage(s.getName());
            slackClient.sendMessage(s.getIsActive().toString());
            slackClient.sendMessage(s.getCreatedData().toString());
            slackClient.sendMessage(s.getUpdatedData().toString());
        }
        return school;
    }
}



































































