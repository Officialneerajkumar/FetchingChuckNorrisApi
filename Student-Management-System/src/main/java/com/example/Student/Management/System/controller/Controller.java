package com.example.Student.Management.System.controller;

import com.example.Student.Management.System.model.Student;
import com.example.Student.Management.System.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping(value = "/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        int studentId = service.addStudent(student);
        return new ResponseEntity<>("student added with studentId : "+studentId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-by-first-name")
    public ResponseEntity<String> getStudentByfirstName(@RequestParam String firstName){
        List<Student> students = service.getStudentByfirstName(firstName);
        return new ResponseEntity<>("students --> "+students,HttpStatus.OK);
    }

    @GetMapping(value = "/get-by-last-name")
    public ResponseEntity<List<Student>> getStudentByLastName(@RequestParam String lastName){
        List<Student> students = service.getStudentByLastName(lastName);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping(value = "/get-by-age")
    public ResponseEntity<List<Student>> getStudentByAge(@RequestParam int age){
        List<Student> students = service.getStudentByAge(age);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping(value = "/get-by-active")
    public ResponseEntity<List<Student>> getStudentByActive(@RequestParam boolean active){
        List<Student> students = service.getStudentByActive(active);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

}
