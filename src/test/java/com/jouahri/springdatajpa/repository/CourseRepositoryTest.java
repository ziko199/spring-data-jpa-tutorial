package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Course;
import com.jouahri.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void saveCourseWithTeacher() {
        // given
        Teacher teacher = Teacher.builder()
                .lastName("Klopp")
                .firstName("Abraham")
                .build();

        Course course = Course.builder()
                .title("Sport")
                .credit(3)
                .teacher(teacher).build();

        // when
        courseRepository.save(course);

        // then
        System.out.println("the object is successfully saved");

    }

    @Test
    public void getContentOfPages() {
        // given
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);

        // when
        List<Course> courses = courseRepository
                .findAll(firstPageWithThreeRecords)
                .getContent();

        // then
        System.out.println("courses = " + courses);
    }

    @Test
    public void getTotalElementsFromPages() {
        // given
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        long expectedValue = 5;

        // when
        long totalElements = courseRepository
                .findAll(firstPageWithThreeRecords)
                .getTotalElements();

        // then
        System.out.println("totalElements = " + totalElements);
        assertEquals(expectedValue, totalElements);
    }

    @Test
    public void getTotalPages() {
        // given
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        long expectedValueFromFirstPage = 2;
        long expectedValueFromSecondPage = 3;

        // when
        long totalPagesFromFirstPage = courseRepository
                .findAll(firstPageWithThreeRecords)
                .getTotalPages();

        long totalPagesFromSecondPage = courseRepository
                .findAll(secondPageWithTwoRecords)
                .getTotalPages();
        // then
        System.out.println("totalPagesFromFirstPage = " + totalPagesFromFirstPage);
        System.out.println("totalPagesFromSecondPage = " + totalPagesFromSecondPage);

        assertAll(
                () -> assertEquals(expectedValueFromFirstPage, totalPagesFromFirstPage),
                () -> assertEquals(expectedValueFromSecondPage, totalPagesFromSecondPage)
        );
    }

    @Test
    public void sortCourseByTitle() {
        // given
        Pageable sortByTitle = PageRequest.of(0,5, Sort.by("title"));

        // when
        List<Course> courses = courseRepository
                .findAll(sortByTitle)
                .getContent();

        // then
        System.out.println("courses = " + courses);
    }

    @Test
    public void sortCourseByTitleAndCredit() {
        // given
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        9,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit")));

        // when
        List<Course> courses = courseRepository
                .findAll(sortByTitle)
                .getContent();

        // then
        System.out.println("courses = " + courses);
    }
}