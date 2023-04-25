package com.example.firstSpringDemo.controler;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Services.CourseService;
import com.example.firstSpringDemo.Services.MarkService;
import com.example.firstSpringDemo.Services.SchoolService;
import com.example.firstSpringDemo.Services.StudentService;
import com.example.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Controller")
public class GeneralController {


@Autowired
SlackClient slackClient;

@GetMapping(value = "test")
public  String test(){
    return "${spring.profiles.active}";

}

@GetMapping(value = "slackMessage")

public void message(@RequestParam String text){
    slackClient.sendMessage(text);
}}