package com.example.hrm.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;


@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy="department",cascade = CascadeType.ALL)
    private List<Employee> employee;



}
