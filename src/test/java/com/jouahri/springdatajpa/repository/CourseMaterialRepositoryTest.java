package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Course;
import com.jouahri.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        // given
        Course course = Course.builder()
                .title("JAVA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.java.de")
                .course(course)
                .build();

        // when
        courseMaterialRepository.save(courseMaterial);

        // then
        System.out.println("the object is successfully saved");
    }

    @Test
    public void printAllCoursesMaterials() {
        // given

        // when
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        // then
        System.out.println("courseMaterials = " + courseMaterials);
    }

    @Test
    public void saveCourseMaterialWithOptionalIsFalse() {
        // given
        Course course = Course.builder()
                .title("Networking")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.networking.de")
                .course(course)
                .build();

        // when
        courseMaterialRepository.save(courseMaterial);

        // then
        System.out.println("the object is successfully saved");
    }
}