package com.example.hrm.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class LabAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean equipmentAllocated;
    @Column(name = "lab_name")
    private String labName;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;




}
