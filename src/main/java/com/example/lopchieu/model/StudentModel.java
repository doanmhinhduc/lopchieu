package com.example.lopchieu.model;

import com.example.lopchieu.entity.Student;

import java.util.List;

public interface StudentModel {
    Student save(Student student);
    List<Student> findAll();
    Student findById(String rollNumber);
    Student undate(String rollNumber);
}
