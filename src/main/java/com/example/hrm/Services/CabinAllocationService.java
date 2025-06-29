package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.CabinAllocationRequest;
import com.example.hrm.DTOs.ResponseDTOS.CabinAllocationResponse;

public interface CabinAllocationService {
    public void createCabinAllocation(CabinAllocationRequest cabinAllocationRequest);
    public void updateCabinAllocation(Long id,CabinAllocationRequest cabinAllocationRequest);
    public boolean existsById( Long id);
    public void deleteCabinAllocation(Long id);
    public CabinAllocationResponse getCabinAllocationById(Long id);
}
