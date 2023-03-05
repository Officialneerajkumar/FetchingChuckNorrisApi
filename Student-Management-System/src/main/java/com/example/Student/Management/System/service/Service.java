package com.example.Student.Management.System.service;

import com.example.Student.Management.System.dao.Repository;
import com.example.Student.Management.System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;
    public int addStudent(Student student) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        student.setAdmissionDate(createTime);
        Student studentOjb = repository.save(student);
        return studentOjb.getStudentId();
    }

    public List<Student> getStudentByfirstName(String firstName) {
        List<Student> students = repository.findStudentByFirstName(firstName);
        return students;
    }

    public List<Student> getStudentByLastName(String lastName) {
        List<Student> students = repository.findStudentByLastName(lastName);
        return students;
    }

    public List<Student> getStudentByAge(int age) {
        List<Student> students = repository.findStudentByAge(age);
        return students;
    }

    public List<Student> getStudentByActive(boolean active) {
        List<Student> students = repository.findStudentByActive(active);
        return students;
    }

}
