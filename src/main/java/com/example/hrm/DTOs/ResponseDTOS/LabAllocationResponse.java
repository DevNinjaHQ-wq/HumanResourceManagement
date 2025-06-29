package com.example.hrm.DTOs.ResponseDTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabAllocationResponse {
    private Long id;
    private boolean equipmentAllocated;
    @JsonProperty("lab_name")
    private String labName;
    private Long employeeId;
}
