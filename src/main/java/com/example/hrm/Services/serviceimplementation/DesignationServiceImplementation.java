package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.DesignationRequest;
import com.example.hrm.DTOs.ResponseDTOS.DesignationResponse;
import com.example.hrm.Entities.Designation;
import com.example.hrm.Repositaries.DesignationRepository;
import com.example.hrm.Services.Designationservice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DesignationServiceImplementation implements Designationservice {
    @Autowired
    DesignationRepository designationRepository;

    @Override
    public void createDesignation(DesignationRequest designationRequest) {
        Designation designation = new Designation();
        designation.setTitle(designationRequest.getTitle());
        designation.setLevel(designationRequest.getLevel());
        designation.setDescription(designationRequest.getDescription());
        designationRepository.save(designation);
    }

    @Override
    public void updateDesignation(Long id ,DesignationRequest designationRequest) {
        Designation designation = designationRepository.findById(designationRequest.getId())
                .orElseThrow(() -> new RuntimeException("designationID not found"));
        designation.setTitle(designationRequest.getTitle());
        designation.setLevel(designationRequest.getLevel());
        designation.setDescription(designation.getDescription());
        designationRepository.save(designation);

    }

    @Override
    public boolean existsById(Long id) {
        return designationRepository.existsById(id);
    }

    @Override
    public void deleteDesignation(Long id) {
        Designation designation = designationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("designation id not founded"));
        designationRepository.delete(designation);
    }

    @Override
    public DesignationResponse getDesignationById(Long id) {
        Designation designation = designationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("designation ID not founded"));
        DesignationResponse designationResponse = new DesignationResponse();
        designationResponse.setId(designation.getId());
        designationResponse.setTitle(designation.getTitle());
        designationResponse.setLevel(designation.getLevel());
        designationResponse.setDescription(designation.getDescription());
        return designationResponse;


    }
}
