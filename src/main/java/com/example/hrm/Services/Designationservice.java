package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.DesignationRequest;
import com.example.hrm.DTOs.ResponseDTOS.DesignationResponse;

public interface Designationservice {
    public void createDesignation(DesignationRequest designationRequest);
    public void updateDesignation(Long id,DesignationRequest designationRequest);
    public boolean existsById(Long id);
    public void deleteDesignation(Long id);
    public DesignationResponse getDesignationById(Long id);

}
