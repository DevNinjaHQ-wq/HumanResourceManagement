package com.example.hrm.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Designation {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String level;
    private String description;

    @OneToMany(mappedBy="designation")
    private List<Employee> employee;





}
