package com.example.schoolsystem.controller;

import com.example.schoolsystem.DTO.Api;
import com.example.schoolsystem.model.Classroom;
import com.example.schoolsystem.model.Teacher;
import com.example.schoolsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers(){
        logger.info("Request in get teachers");
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping
    public ResponseEntity<Api> AddTeacher(@RequestBody @Valid Teacher teacher){
        logger.info("Request in add teacher ");
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new Api("Teacher added !",201));
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Api> checkTeacherIsValid(@PathVariable Integer id){
        logger.info("Request in get teacher by id");
        teacherService.checkTeacher(id);
        return ResponseEntity.status(200).body(new Api("Student get by id",201));

    }
}
