package com.example.firstSpringDemo.Repositores;

import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Studentrepositores  extends CrudRepository<Student, Integer > {

    @Query(value ="SELECT s from Student s")
    List<Student> getAllStudents();

    @Query(value = "SELECT s from Student s where s.id = :id")
    List<Student> getStudentById(@Param("id") Integer id);


    @Query(value = "SELECT s from Student s where s.name = :studentName")
    List<Student> geStudentByStudentName(@Param("studentName") String studentName);
}
