package com.analytiq.jobportalunnati.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analytiq.jobportalunnati.core.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}