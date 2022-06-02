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
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id is required !")
    private Integer id;
    @NotEmpty(message = "Name is required !")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> student;

    public Classroom(Integer id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }
}
