package com.example.schoolsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id is required !")
    private Integer id;
    @NotEmpty(message = "Name is required !")
    private String name;
    @NotNull(message = "Age is required !")
    private Integer age;
    @NotEmpty(message = "Major is required !")
    private String major;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Classroom> classroom;
}
