package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Repositores.MarkRepository;
import com.example.firstSpringDemo.Repositores.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<Mark> getMarkByMarkGrade(String markGrade) {
        List<Mark> mark = markRepository.getMarkByMarkGrade(markGrade);
        return mark;
    }

    public List<Mark> getAllIsActive() {
        List<Mark> mark = markRepository.getIsActive();
        return mark;
    }

    public List<Mark> getAllIsInActive() {
        List<Mark> mark = markRepository.getIsInActive();
        return mark;
    }

    public List<Mark> getAllLastRow() {
        List<Mark> mark = markRepository.getLatestRow();
        return mark;
    }

    public List<Mark> getAllLatestUpdated() {
        List<Mark> mark = markRepository.getLatestUpdated();
        return mark;
    }

    public List<Mark> getMarkCreatedAfterDate(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDataFromStringToDataFormat = formatter.parse(data);
        List<Mark> mark = markRepository.getMarkCreatedAfterDate(convertedDataFromStringToDataFormat);
        return mark;
    }

    public void deleteById(Integer id){
        Mark mark = markRepository.getMarkById(id);
        mark.setIsActive(false);
        markRepository.save(mark);
    }


    public void setAllIsActiveFalse() {
        List<Mark> mark = markRepository.getAllMarks();
        for (Mark s : mark){
            s.setIsActive(false);
        }
        markRepository.saveAll(mark);
    }

    public void setAllIsActiveFalseAfterCreatdDate(String creatdDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat( "yyyy_mm_dd");
        Date creatdDatee = formatter.parse(creatdDate);
        List<Mark> mark = markRepository.getMarkByCreatedDate(creatdDatee);
        for (Mark s : mark) {
            s.setIsActive(false);
        }
        markRepository.saveAll(mark);
    }










}
