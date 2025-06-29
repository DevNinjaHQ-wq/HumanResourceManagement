package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.DepartmentRequest;
import com.example.hrm.DTOs.ResponseDTOS.DepartmentResponse;

import java.util.List;

public interface Departmentservice {
    public void createDepartment(DepartmentRequest departmentRequest);
    public void updateDepartment(Long id,DepartmentRequest departmentRequest);
    public void deleteDepartment(Long id);
    public boolean existsById(Long id);
    public DepartmentResponse getDepartmentById(Long id);
    public List<DepartmentResponse> getAllDepartment();

}

