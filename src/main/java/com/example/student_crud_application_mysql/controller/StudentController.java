package com.example.student_crud_application_mysql.controller;

import com.example.student_crud_application_mysql.entity.Student;
import com.example.student_crud_application_mysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
        @Autowired
    private StudentService studentService;

        @PostMapping("/add")
    public String add(@RequestBody Student student){
            studentService.saveStudent(student);
            return "added the student..";
        }
        @GetMapping("/getall")
    public List<Student> getAllStudent(){
            return studentService.getAllStudent();
        }
}
