package com.example.hrm.DTOs.ResponseDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayRollResponse {
    private Long id;
    private int month;
    private Long basicSalary;
    private Long deduction;
    private Long netPay;
    private Long employee_id;
}
