package com.example.firstSpringDemo.controler;

import com.example.firstSpringDemo.Models.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SchoolControllerTest {

    @Autowired
    SchoolController schoolController;
    @Test
    void getSchoolById()throws Exception {
            String schoolName=schoolController.getSchoolById(1).getName();
            assertEquals("thikra",schoolName);

        }

    @Test
    void getIsActive() {
        List<School> schools = schoolController.getIsActive();
        for(School sc : schools) {
            assertEquals(true, sc.getIsActive());
        }
    }



}

