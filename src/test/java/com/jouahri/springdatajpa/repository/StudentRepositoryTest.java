package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        // given
        Student student = Student.builder()
                .emailId("zakaria.jouahri@outlook.de")
                .firstName("Zakaria")
                .lastName("Jouahri")
                .guardianName("Outmane Jouahri")
                .guardianEmail("outmane.jouahri@outlook.de")
                .guardianMobile("012 345678")
                .build();

        // when
        studentRepository.save(student);

        // then
        System.out.println("the object is successfully created");
    }

    @Test
    public void printAllStudent() {
        // given

        // when
        List<Student> studentList = studentRepository.findAll();

        // then
        System.out.println("studentList = " + studentList);
    }
}