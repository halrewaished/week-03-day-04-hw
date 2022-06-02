package com.example.schoolsystem.service;

import com.example.schoolsystem.exception.InvalidIdException;
import com.example.schoolsystem.model.Classroom;
import com.example.schoolsystem.model.Student;
import com.example.schoolsystem.repository.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    public void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }
    public Classroom getClassroomByID(Integer id) {
        return classroomRepository.findById(id).get();
    }

    public void checkClassroom(Integer id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(
                        ()-> new InvalidIdException("Invalid id"));
    }
}
