package com.example.firstSpringDemo.Repositores;

import com.example.firstSpringDemo.Models.Mark;
import com.example.firstSpringDemo.Models.School;
import com.example.firstSpringDemo.Models.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SchoolRepository  extends CrudRepository<School, Integer > {
  @Query("SELECT s from School s")
  List<School> getAllSchools();


  @Query(value = "SELECT s from School s where s.id = :id")
  School getSchoolById(@Param("id") Integer id);

  @Query(value = "SELECT s from School s where s.name = :schoolName")
  List<School> getSchoolBySchoolName(@Param("schoolName") String schoolName);


  @Query(value = "SELECT s from School s where s.isActive = 1")
  List<School> getIsActive();

  @Query(value = "SELECT s from School s where s.isActive = 0")
  List<School> getIsInActive();


  @Query(value = "SELECT s FROM School s WHERE s.id=(SELECT max(s.id) FROM School s)")
  List<School> getLatestRow();

  @Query(value = "select s from School s where s.updatedData=(select max(s.updatedData) from School s)")
  List<School> getLatestUpdated();


  @Query("SELECT s from School s where s.createdData > :createdData")
  List<School> getSchoolCreatedAfterDate(@Param("createdData") Date createdData);

  @Query("SELECT s from School s where s.createdData = :createdData")
  List<School> getSchoolByCreatedDate(@Param("createdData") Date createdData);

  @Query("SELECT s from School s where s.updatedData = :updatedData")
  List<School> getSchoolByUpdatedDate(@Param("updatedData") Date updatedData);




}
