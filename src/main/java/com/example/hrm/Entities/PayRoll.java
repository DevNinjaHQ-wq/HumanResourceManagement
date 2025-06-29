package com.example.hrm.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PayRoll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int month;
    private Long basicSalary;
    private Long deduction;
    private Long netPay;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="employee_id")
    private Employee employee;

}
