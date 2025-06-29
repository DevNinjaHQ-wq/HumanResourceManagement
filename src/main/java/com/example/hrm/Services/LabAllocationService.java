package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.LabAllocationRequest;
import com.example.hrm.DTOs.ResponseDTOS.LabAllocationResponse;

public interface LabAllocationService {
    public void createLabAllocation (LabAllocationRequest labAllocationRequest);
    public void updateLabAllocation(Long id,LabAllocationRequest labAllocationRequest);
    public boolean existsById(Long id);
    public void deleteLabAllocation(Long id);
    public LabAllocationResponse getLabAllocationById(Long id);
}
