package com.example.firstSpringDemo.Repositores;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourselRepository  extends CrudRepository<Course, Integer > {

    @Query("SELECT s from Course s")
    List<Course> getAllCourses();


    @Query(value = "SELECT s from Course s where s.id = :id")
    Course getCourseById(@Param("id") Integer id);


    @Query(value = "SELECT s from Course s where s.courseName = :courseName")
    List<Course> getCourseByCourseName(@Param("courseName") String courseName);

    @Query(value = "SELECT s from Course s where s.isActive = 1")
    List<Course> getIsActive();


    @Query(value = "SELECT s from Course s where s.isActive = 0")
    List<Course> getIsInActive();


    @Query(value = "SELECT s FROM Course s WHERE s.id=(SELECT max(s.id) FROM Course s)")
    List<Course> getLatestRow();

    @Query(value = "select s from Course s where s.updatedData=(select max(s.updatedData) from Course s)")
    List<Course> getLatestUpdated();

    @Query("SELECT s from Course s where s.createdData > :createdData")
    List<Course> getCourseCreatedAfterDate(@Param("createdData") Date createdData);

    @Query("SELECT s from Course s where s.createdData = :createdData")
    List<Course> getCourseByCreatedDate(@Param("createdData") Date createdData);

    @Query("SELECT s from Course s where s.updatedData = :updatedData")
    List<Course> getCourseByUpdatedDate(@Param("updatedData") Date updatedData);









}
