package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.LabAllocationRequest;
import com.example.hrm.DTOs.ResponseDTOS.LabAllocationResponse;
import com.example.hrm.Entities.LabAllocation;
import com.example.hrm.Repositaries.EmployeeRepository;
import com.example.hrm.Repositaries.LabAllocationRepository;
import com.example.hrm.Services.LabAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LabAllocationServiceImplementation implements LabAllocationService {
    @Autowired
    LabAllocationRepository labAllocationRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createLabAllocation(LabAllocationRequest labAllocationRequest){
        LabAllocation allocation = new LabAllocation();
        allocation.setEquipmentAllocated(labAllocationRequest.isEquipmentAllocated());
        allocation.setLabName(labAllocationRequest.getLabName());


        if (labAllocationRequest.getEmployeeId() != null) {
            employeeRepository.findById(labAllocationRequest.getEmployeeId()).ifPresent(allocation::setEmployee);
        }
       labAllocationRepository.save(allocation);

    }
    @Override
    public void updateLabAllocation(Long id,@RequestBody LabAllocationRequest labAllocationRequest) {
        LabAllocation allocation = labAllocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lab allocation not found"));

        allocation.setEquipmentAllocated(labAllocationRequest.isEquipmentAllocated());
        allocation.setLabName(labAllocationRequest.getLabName());

        if (labAllocationRequest.getEmployeeId() != null) {
            employeeRepository.findById(labAllocationRequest.getEmployeeId())
                    .ifPresent(allocation::setEmployee);
        }
        labAllocationRepository.save(allocation);
    }

    @Override
    public boolean existsById(Long id){
        return employeeRepository.existsById(id);
    }

    @Override
    public void deleteLabAllocation(@PathVariable Long id){
        LabAllocation labAllocation = labAllocationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Lab allocation Id not founded"));
        labAllocationRepository.delete(labAllocation);
    }
    @Override
    public LabAllocationResponse getLabAllocationById (Long id){
        LabAllocation labAllocation = labAllocationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("lab allocation ID not founded"));
        LabAllocationResponse labAllocationResponse = new LabAllocationResponse();
        labAllocationResponse.setId(labAllocation.getId());
        labAllocationResponse.setLabName(labAllocation.getLabName());
        labAllocationResponse.setEquipmentAllocated(labAllocation.isEquipmentAllocated());
        labAllocationResponse.setEmployeeId(labAllocation.getEmployee().getId());
        return labAllocationResponse;
    }



}



