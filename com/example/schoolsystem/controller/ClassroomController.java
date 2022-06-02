package com.example.schoolsystem.controller;

import com.example.schoolsystem.DTO.Api;
import com.example.schoolsystem.DTO.ClassDTO;
import com.example.schoolsystem.model.Classroom;
import com.example.schoolsystem.model.Student;
import com.example.schoolsystem.model.Teacher;
import com.example.schoolsystem.service.ClassroomService;
import com.example.schoolsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;
    private final TeacherService teacherService;

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);

    @GetMapping
    public ResponseEntity<List<Classroom>> getClassrooms(){
        logger.info("Request in get classrooms");
        return ResponseEntity.status(200).body(classroomService.getClassrooms());
    }

    @PostMapping
    public ResponseEntity<Api> AddClassroom(@RequestBody @Valid Classroom classroom){
        logger.info("Request in add classroom ");
        classroomService.addClassroom(classroom);
        return ResponseEntity.status(200).body(new Api("Classroom added !",201));
    }

    @GetMapping("/classroom/{id}")
    public ResponseEntity<Api> checkClassroomIsValid(@PathVariable Integer id){
        logger.info("Request in get classroom by id");
        classroomService.checkClassroom(id);
        return ResponseEntity.status(200).body(new Api("Classroom get by id",201));

    }

    @PostMapping("/add-classroom")
    public ResponseEntity addClassToTeacher(@RequestBody ClassDTO cd){
        logger.info("Request in add Class to teacher");
        Teacher teacher = teacherService.getTeacherByID(cd.getClassId());
        Classroom classrooms = new Classroom(cd.getClassId(), cd.getName(),teacher);
        teacher.getClassrooms().add(classrooms);
        classroomService.addClassroom(classrooms);
        return ResponseEntity.status(200).body(classroomService.getClassrooms());
    }

}
