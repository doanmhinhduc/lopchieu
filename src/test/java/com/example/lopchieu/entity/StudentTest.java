package com.example.lopchieu.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void TestCreateStudent(){
       Student student = new Student();
       student.setRollNumber("A001");
       student.setFullName("doanminhduc");
       student.setEmail("ducmk23@gmail.com");
       student.setPhone("01234567");


    }
}