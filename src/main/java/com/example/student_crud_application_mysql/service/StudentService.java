package com.example.student_crud_application_mysql.service;

import com.example.student_crud_application_mysql.entity.Student;

import java.util.List;

public interface StudentService {
        public Student saveStudent(Student student);
        public List<Student> getAllStudent();
}
