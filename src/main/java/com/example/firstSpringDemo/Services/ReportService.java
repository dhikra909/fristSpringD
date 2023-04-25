package com.example.firstSpringDemo.Services;

import com.example.firstSpringDemo.DTO.CourseMarkDTO;
import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import com.example.firstSpringDemo.Models.Shoolstudent;
import com.example.firstSpringDemo.Repositores.CourselRepository;
import com.example.firstSpringDemo.Repositores.MarkRepository;
import com.example.firstSpringDemo.Repositores.SchoolRepository;
import com.example.firstSpringDemo.Repositores.Studentrepositores;
import com.jayway.jsonpath.internal.function.numeric.Average;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fill.AbstractVariableReturnValueSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportService {
    public static final String pathToReports = "C:\\Users\\user022\\Downloads\\Reports";
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    CourseMarkDTO courseMarkDTO;
    @Autowired
    CourselRepository courselRepository;
    @Autowired
    MarkRepository markRepository;


    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();
        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Dhikra");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }


@Autowired
    Studentrepositores studentrepositores;
    public String studentrepositores() throws FileNotFoundException, JRException {
        List<Student> studentList = studentrepositores.getAllStudents();
        List<Shoolstudent> shoolstudentList = new ArrayList<>();
        for (Student studentListVariable : studentList) {
            String schoolName = studentListVariable.getSchool().getName();
            String studentName = studentListVariable.getName();
            String studentRollNumber = studentListVariable.getRollNumber();
            Shoolstudent shoolstudent = new Shoolstudent(schoolName, studentName, studentRollNumber);
            shoolstudentList.add(shoolstudent);
        }

        File file = new File("C:\\Users\\user022\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\student.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(shoolstudentList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "TechM");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\student.pdf");
        return "Report generated : " + pathToReports+"\\student.pdf";
    }


    public String courseMarkDTO() throws JRException {

        List<Course> courseList = (List<Course>) courselRepository.findAll();
        List<CourseMarkDTO> courseMarkDTOList = new ArrayList<>();
        for (Course course : courseList) {
            String courseName = course.getCourseName();
            Integer averageMark = markRepository.getAverageOfMarksByCourseName(courseName);
            courseMarkDTOList.add(new CourseMarkDTO(courseName, averageMark));
        }
        File file = new File("C:\\Users\\MuhammadDaniyal\\Downloads\\Daniyal\\CourseApi\\src\\main\\resources\\AverageMark.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseMarkDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Daniyal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\courseAverageMark.pdf");
        return "Report generated : " + pathToReports + "\\courseAverageMark.pdf";
    }


}
