package com.example.hrm.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class CabinAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cabinNumber;
    private int floor;

    @OneToMany(mappedBy="cabin",cascade=CascadeType.ALL)
    private List<Employee> employee;


}
