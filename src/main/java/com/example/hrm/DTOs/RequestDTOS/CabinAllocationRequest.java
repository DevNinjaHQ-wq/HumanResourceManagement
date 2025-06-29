package com.example.hrm.DTOs.RequestDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CabinAllocationRequest {
    private Long id;
    private Long cabinNumber;
    private int floor;
}
