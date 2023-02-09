package com.example.firstSpringDemo.Repositores;

import com.example.firstSpringDemo.Models.Course;
import com.example.firstSpringDemo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourselRepository  extends CrudRepository<Course, Integer > {
}
