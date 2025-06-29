package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.CabinAllocationRequest;
import com.example.hrm.DTOs.ResponseDTOS.CabinAllocationResponse;
import com.example.hrm.Entities.BusinessCard;
import com.example.hrm.Entities.CabinAllocation;
import com.example.hrm.Repositaries.CabinAllocationRepository;
import com.example.hrm.Services.CabinAllocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CabinAllocationServiceImplementation implements CabinAllocationService {
    @Autowired
    CabinAllocationRepository cabinAllocationRepository;

    @Override
    public void createCabinAllocation (CabinAllocationRequest cabinAllocationRequest){
        CabinAllocation cabinAllocation= new CabinAllocation();
        cabinAllocation.setCabinNumber(cabinAllocationRequest.getCabinNumber());
        cabinAllocation.setFloor(cabinAllocationRequest.getFloor());
        cabinAllocationRepository.save(cabinAllocation);
    }
    @Override
    public void updateCabinAllocation ( Long id,CabinAllocationRequest cabinAllocationRequest){
        CabinAllocation cabin = cabinAllocationRepository.findById(cabinAllocationRequest.getId())
                .orElseThrow(()-> new RuntimeException("designationID not found"));
        cabin.setCabinNumber(cabinAllocationRequest.getCabinNumber());
        cabin.setFloor(cabinAllocationRequest.getFloor());
        cabinAllocationRepository.save(cabin);
    }
    @Override
    public boolean existsById(Long id){
        return cabinAllocationRepository.existsById(id);
    }

    @Override
    public void deleteCabinAllocation(@PathVariable Long id){
        CabinAllocation cabinAllocation = cabinAllocationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("cabin allocation id not founded"));
        cabinAllocationRepository.delete(cabinAllocation);
    }
    @Override
    public CabinAllocationResponse getCabinAllocationById (Long id){
        CabinAllocation cabinAllocation = cabinAllocationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("cabin allocation ID not founded"));
        CabinAllocationResponse cabinAllocationResponse = new CabinAllocationResponse();
        cabinAllocationResponse.setId(cabinAllocation.getId());
        cabinAllocationResponse.setCabinNumber(cabinAllocation.getCabinNumber());
        cabinAllocationResponse.setFloor(cabinAllocation.getFloor());
        return cabinAllocationResponse;


    }
}
