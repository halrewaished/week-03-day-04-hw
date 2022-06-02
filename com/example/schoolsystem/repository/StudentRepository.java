package com.example.schoolsystem.repository;


import com.example.schoolsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
