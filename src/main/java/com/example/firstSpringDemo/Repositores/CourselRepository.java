package com.example.firstSpringDemo.Repositores;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourselRepository  extends CrudRepository<Course, Integer > {

    @Query("SELECT s from Course s")
    List<Course> getAllCourses();


    @Query(value = "SELECT s from Course s where s.id = :id")
    List<Course> getCourseById(@Param("id") Integer id);


    @Query(value = "SELECT s from Course s where s.courseName = :courseName")
    List<Course> getCourseByCourseName(@Param("courseName") String courseName);




}
