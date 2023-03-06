package com.example.firstSpringDemo.Repositores;

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
public interface MarkRepository  extends CrudRepository<Mark, Integer > {

    @Query("SELECT s from Mark s")
    List<Mark> getAllMarks();


    @Query(value = "SELECT s from Mark s where s.id = :id")
    Mark getMarkById(@Param("id") Integer id);

    @Query(value = "SELECT s from Mark s where s.grade = :grade")
    List<Mark> getMarkByMarkGrade(@Param("grade") String grade);

    @Query(value = "SELECT s from Mark s where s.isActive = 1")
    List<Mark> getIsActive();

    @Query(value = "SELECT s from Mark s where s.isActive = 0")
    List<Mark> getIsInActive();

    @Query(value = "SELECT s FROM Mark s WHERE s.id=(SELECT max(s.id) FROM Mark s)")
    List<Mark> getLatestRow();

    @Query(value = "select s from Mark s where s.updatedData=(select max(s.updatedData) from Mark s)")
    List<Mark> getLatestUpdated();


    @Query("SELECT s from Mark s where s.createdData > :createdData")
    List<Mark> getMarkCreatedAfterDate(@Param("createdData") Date createdData);

    @Query("SELECT s from Mark s where s.createdData = :createdData")
    List<Mark> getMarkByCreatedDate(@Param("createdData") Date createdData);

    @Query("SELECT s from Mark s where s.updatedData = :updatedData")
    List<Mark> getMarkByUpdatedDate(@Param("updatedData") Date updatedData);











}
