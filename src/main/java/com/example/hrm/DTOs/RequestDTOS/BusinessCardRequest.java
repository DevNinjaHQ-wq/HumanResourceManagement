package com.example.hrm.DTOs.RequestDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BusinessCardRequest {
    private Long id;
    private String name;
    private String title;
    private String email;
    private String phone;
    private String company;
    private Long employee_id;
}
