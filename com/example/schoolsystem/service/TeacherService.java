package com.example.schoolsystem.service;

import com.example.schoolsystem.exception.InvalidIdException;
import com.example.schoolsystem.model.Student;
import com.example.schoolsystem.model.Teacher;
import com.example.schoolsystem.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {

        teacherRepository.save(teacher);
    }

    public Teacher getTeacherByID(Integer id) {
        return teacherRepository.findById(id).get();
    }

    public void checkTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid id"));
    }
}
