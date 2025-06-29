package com.example.hrm.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Documents {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String documentType;
    private String fileName;

    @ManyToMany(mappedBy = "documents")
    private List<Employee> employees;



}
