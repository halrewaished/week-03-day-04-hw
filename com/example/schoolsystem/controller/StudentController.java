package com.example.schoolsystem.controller;

import com.example.schoolsystem.DTO.Api;
import com.example.schoolsystem.model.Classroom;
import com.example.schoolsystem.model.Student;
import com.example.schoolsystem.service.ClassroomService;
import com.example.schoolsystem.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ClassroomService classroomService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("Request in get students");
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<Api> AddStudents(@RequestBody @Valid Student student){
        logger.info("Request in add student ");
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new Api("Student added !",201));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Api> checkStudentIsValid(@PathVariable Integer id){
        logger.info("Request in get student by id");
        studentService.checkStudent(id);
        return ResponseEntity.status(200).body(new Api("Student get by id",201));

    }

    @PostMapping("/class/{roomId}/{studentId}")
    public ResponseEntity<List<Student>> addClassToStudent(@PathVariable Integer roomId,@PathVariable Integer studentId){
        logger.info("Request in add classroom to student");
        Student student = studentService.getStudentByID(studentId);
        Classroom classroom = classroomService.getClassroomByID(roomId);
        student.getClassroom().add(classroom);
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

}
