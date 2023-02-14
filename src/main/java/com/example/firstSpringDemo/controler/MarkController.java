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

    @RequestMapping(value = "Mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> mark = markService.getAllMarks();
        return mark;
    }

    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public List<Mark> getMarkById(@RequestParam Integer id) {
        List<Mark> mark = markService.getMarkById(id);
        return mark;
    }

    @RequestMapping(value = "mark/getMarkByMarkgrade", method = RequestMethod.GET)
    public List<Mark> getMarkByMarkgrade(@RequestParam String markgrade) {
        List<Mark> mark = markService.getMarkByMarkGrade(markgrade);
        return mark;
    }
}
