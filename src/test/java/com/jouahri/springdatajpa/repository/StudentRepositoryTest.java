package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Guardian;
import com.jouahri.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
                //.guardianName("Outmane Jouahri")
                //.guardianEmail("outmane.jouahri@outlook.de")
                //.guardianMobile("012 345678")
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
        List<Student> students = studentRepository.findAll();

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void saveStudentWithGuardian() {
        // given
        Guardian guardian = Guardian.builder()
                .name("Outmane Jouahri")
                .email("outmane.jouahri@outlook.de")
                .mobile("012 345678")
                .build();

        Student student = Student.builder()
                .emailId("sadio.max@outlook.de")
                .firstName("Sadio")
                .lastName("Max")
                .guardian(guardian)
                .build();

        // when
        studentRepository.save(student);

        // then
        System.out.println("the object is successfully created");
    }

    @Test
    public void printStudentByFirstName() {
        // given
        String firstName = "Zakaria";

        // when
        List<Student> students = studentRepository.findByFirstName(firstName);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastName() {
        // given
        String lastName = "Jouahri";

        // when
        List<Student> students = studentRepository.findByLastName(lastName);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByStudentId() {
        // given
        Long studentId = 10L;

        // when
        List<Student> students = studentRepository.findByStudentId(studentId);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardian() {
        // given
        Guardian guardian = Guardian.builder()
                .name("Outmane Jouahri")
                .email("outmane.jouahri@outlook.de")
                .mobile("012 345678")
                .build();

        // when
        List<Student> students = studentRepository.findByGuardian(guardian);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        // given
        String guardianName = "Outmane Jouahri";

        // when
        List<Student> students = studentRepository.findByGuardianName(guardianName);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastNameNotNull() {
        // given

        // when
        List<Student> students = studentRepository.findByLastNameNotNull();

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        // given
        String firstName = "Zakaria";
        String lastName = "Jouahri";

        // when
        List<Student> students = studentRepository.findByFirstNameAndLastName(firstName, lastName);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastNameIsStartingWith() {
        // given
        String firstWord = "J";

        // when
        List<Student> students = studentRepository.findByLastNameIsStartingWith(firstWord);

        // then
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastNameContaining() {
        // given
        String name = "ua";

        // when
        List<Student> students = studentRepository.findByLastNameContaining(name);

        // then
        System.out.println("students = " + students);
    }
}