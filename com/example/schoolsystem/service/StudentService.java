package com.example.schoolsystem.service;

import com.example.schoolsystem.exception.InvalidIdException;
import com.example.schoolsystem.model.Student;
import com.example.schoolsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        studentRepository.save(student);
    }

    public Student getStudentByID(Integer id) {
        return studentRepository.findById(id).get();
    }

    public void checkStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid id"));
    }

}
