package com.example.hrm.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String position;
    private String status;


    @ManyToOne
    @JoinColumn(name="designation_id")
    private Designation designation;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @OneToMany (mappedBy="employee", cascade = CascadeType.ALL)
    private List<LabAllocation> labAllocation;

    @ManyToOne
    @JoinColumn(name ="cabin_id")
    private CabinAllocation cabin;

    @ManyToMany
    @JoinTable(
            name = "employee_documents",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private List<Documents> documents;


    @OneToOne(mappedBy ="employee", cascade=CascadeType.ALL)
    private PayRoll payroll;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private BusinessCard businessCard;
}
