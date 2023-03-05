package com.example.Student.Management.System.dao;

import com.example.Student.Management.System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Student,Integer> {

    @Query(value = "select * from tbl_student where first_name = :firstName",nativeQuery = true)
    List<Student> findStudentByFirstName(String firstName);

    @Query(value = "select * from tbl_student where last_name = :lastName",nativeQuery = true)
    List<Student> findStudentByLastName(String lastName);

    @Query(value = "select * from tbl_student where age = :age",nativeQuery = true)
    List<Student> findStudentByAge(int age);

    @Query(value = "select * from tbl_student where active = :active",nativeQuery = true)
    List<Student> findStudentByActive(boolean active);
}
