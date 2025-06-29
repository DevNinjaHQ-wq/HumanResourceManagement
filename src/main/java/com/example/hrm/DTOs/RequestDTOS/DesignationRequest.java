package com.example.hrm.DTOs.RequestDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesignationRequest {
    private Long id;
    private String title;
    private String level;
    private String description;
}
