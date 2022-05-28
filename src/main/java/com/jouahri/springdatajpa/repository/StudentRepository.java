package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.Guardian;
import com.jouahri.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * for more information how to create JPA query method read documentation below
 * @see <a https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation </a>
 *
 * Created by @author Zakaria Jouahri on 28/05/2022.
 * */
@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

    // find+By+AttributeName
    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByStudentId(Long studentId);

    List<Student> findByGuardian(Guardian guardian);

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByLastNameNotNull();

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findByLastNameIsStartingWith(String firstWord);

    List<Student> findByLastNameContaining(String name);

    // JPQL
    @Query("select s from Student as s where s.emailId = ?1")
    Student getStudentByEmailAddress(String email);

    // JPQL
    @Query("select s.firstName from Student as s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String email);
}