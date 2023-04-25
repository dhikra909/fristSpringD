package com.example.firstSpringDemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CourseMarkDTO {


   String course_name;
   Integer obtained_marks;

   String grade;
   Integer averageMark;

   public CourseMarkDTO(String course_name, Integer averageMark) {
      this.course_name = course_name;
      this.averageMark = averageMark;
   }

}
