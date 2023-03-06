package com.example.firstSpringDemo.Repositores;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface Studentrepositores  extends CrudRepository<Student, Integer > {

    @Query(value ="SELECT s from Student s")
    List<Student> getAllStudents();

    @Query(value = "SELECT s from Student s where s.id = :id")
    Student getStudentById(@Param("id") Integer id);


    @Query(value = "SELECT s from Student s where s.name = :studentName")
    List<Student> geStudentByStudentName(@Param("studentName") String studentName);


    @Query(value = "SELECT st from Student st where st.school.id = :id")
    List<Student> geStudentBySchoolId(@Param("id") Integer id);

    @Query(value = "SELECT s from Student s where s.isActive = 1")
    List<Student> getIsActive();

    @Query(value = "SELECT s from Student s where s.isActive = 0")
    List<Student> getIsInActive();

    @Query(value = "SELECT s FROM Student s WHERE s.id=(SELECT max(s.id) FROM Student s)")
    List<Student> getLatestRow();

    @Query(value = "select s from Student s where s.updatedData=(select max(s.updatedData) from Student s)")
    List<Student> getLatestUpdated();


    @Query("SELECT s from Student s where s.createdData > :createdData")
    List<Student> getStudentAfterCreatedDate(@Param("createdData") Date createdData);

    @Query("SELECT s from Student s where s.createdData = :createdData")
    List<Student> getStudentByCreatedDate(@Param("createdData") Date createdData);

    @Query("SELECT s from Student s where s.updatedData = :updatedData")
    List<Student> getStudentByUpdatedDate(@Param("updatedData") Date updatedData);

















}
