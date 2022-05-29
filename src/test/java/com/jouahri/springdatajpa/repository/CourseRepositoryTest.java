package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Course;
import com.jouahri.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses () {
        // given

        // when
        List<Course> courses = courseRepository.findAll();

        // then
        System.out.println("courses = " + courses);
    }
}