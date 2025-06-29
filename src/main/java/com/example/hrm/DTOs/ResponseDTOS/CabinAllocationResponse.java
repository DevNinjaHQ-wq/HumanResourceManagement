package com.example.hrm.DTOs.ResponseDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CabinAllocationResponse {
    private Long id;
    private Long cabinNumber;
    private int floor;
}
