package com.example.firstSpringDemo.controler;


import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "mark")
public class MarkController {

    @Autowired
    MarkService markService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> mark = markService.getAllMarks();
        return mark;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public List<Mark> getMarkById(@RequestParam Integer id) {
        List<Mark> mark = markService.getMarkById(id);
        return mark;
    }

    @RequestMapping(value = "/getMarkByMarkgrade", method = RequestMethod.GET)
    public List<Mark> getMarkByMarkgrade(@RequestParam String markgrade) {
        List<Mark> mark = markService.getMarkByMarkGrade(markgrade);
        return mark;
    }

    @RequestMapping(value = "/getIsActive", method = RequestMethod.GET)
    public List<Mark> getIsActive() {
        List<Mark> mark = markService.getAllIsActive();
        return mark;
    }


    @RequestMapping(value = "/getIsInActive", method = RequestMethod.GET)
    public List<Mark> getIsInActive() {
        List<Mark> mark = markService.getAllIsInActive();
        return mark;
    }





}
