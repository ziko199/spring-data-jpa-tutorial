package com.jouahri.springdatajpa.repository;

import com.jouahri.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository <CourseMaterial, Long> {

}