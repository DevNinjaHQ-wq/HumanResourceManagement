package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.EmployeeRequest;
import com.example.hrm.DTOs.ResponseDTOS.EmployeeResponse;

public interface EmployeeService {
    public void createEmployee(EmployeeRequest employeeRequest);
    public void updateEmployee(EmployeeRequest employeeRequest);
    public boolean existsById(Long id);
    public void deleteEmployee(Long id);
    public EmployeeResponse getEmployee(Long id);
}

