package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Repositores.MarkRepository;
import com.example.firstSpringDemo.Repositores.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {


    @Autowired
    MarkRepository markRepository;

    public List<Mark> getAllMarks() {
        return markRepository.getAllMarks();
    }


    public Mark getMarkById(Integer id) {
        Mark mark = markRepository.getMarkById(id);
        return mark;
    }

    public Mark getMarkByMarkGrade(String markGrade) {
        Mark mark = markRepository.getMarkByMarkGrade(markGrade);
        return mark;
    }




}
