package com.example.schoolsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id is required !")
    private Integer id;
    @NotEmpty(message = "Name is required !")
    private String name;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;


}
