package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Course;
import com.jouahri.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        // given
        Course pythonCourse = Course.builder()
                .title("Python")
                .credit(5)
                .build();
        Course MathCourse = Course.builder()
                .title("Math 1")
                .credit(10)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mohammed")
                .lastName("Lehmann")
                .courses(Set.of(pythonCourse, MathCourse))
                .build();

        // when
        teacherRepository.save(teacher);

        // then
        System.out.println("the object is successfully saved");

    }
}