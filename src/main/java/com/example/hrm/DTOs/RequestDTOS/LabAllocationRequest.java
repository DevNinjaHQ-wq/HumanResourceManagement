package com.example.hrm.DTOs.RequestDTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabAllocationRequest {
    private Long id;
    private boolean equipmentAllocated;
    @JsonProperty("lab_name")
    private String labName;
    private Long employeeId;
}
