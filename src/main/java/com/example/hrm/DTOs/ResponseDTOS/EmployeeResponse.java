package com.example.hrm.DTOs.ResponseDTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String position;
    private String status;

    private Long designationId;
    private Long departmentId;
    private Long cabinId;
}
