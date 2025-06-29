package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.EmployeeRequest;
import com.example.hrm.DTOs.ResponseDTOS.EmployeeResponse;
import com.example.hrm.Entities.CabinAllocation;
import com.example.hrm.Entities.Department;
import com.example.hrm.Entities.Designation;
import com.example.hrm.Entities.Employee;
import com.example.hrm.Repositaries.CabinAllocationRepository;
import com.example.hrm.Repositaries.DepartmentRepository;
import com.example.hrm.Repositaries.DesignationRepository;
import com.example.hrm.Repositaries.EmployeeRepository;
import com.example.hrm.Services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DesignationRepository designationRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CabinAllocationRepository cabinAllocationRepository;

    @Override
    public void createEmployee(EmployeeRequest employeeRequest){
        Employee employee =new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmailAddress(employeeRequest.getEmailAddress());
        employee.setPosition(employeeRequest.getPosition());
        employee.setStatus(employeeRequest.getStatus());

        if (employee.getDesignation() != null) {
            Designation designation = designationRepository.findById(employee.getDesignation().getId())
                    .orElse(null);
            employee.setDesignation(designation);
        }
        if (employee.getDepartment() != null) {
            Department department = departmentRepository.findById(employee.getDepartment().getId())
                    .orElse(null);
            employee.setDepartment(department);
        }
        if (employee.getCabin() != null) {
            CabinAllocation cabin = cabinAllocationRepository.findById(employee.getCabin().getId())
                    .orElse(null);
            employee.setCabin(cabin);
        }

        BeanUtils.copyProperties(employeeRequest , employee);
        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(employeeRequest.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmailAddress(employeeRequest.getEmailAddress());
        employee.setPosition(employeeRequest.getPosition());
        employee.setStatus(employeeRequest.getStatus());

        // Update Designation
        if (employeeRequest.getDesignationId() != null) {
            Designation designation = designationRepository.findById(employeeRequest.getDesignationId()).orElse(null);
            employee.setDesignation(designation);
        }

        // Update Department
        if (employeeRequest.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeRequest.getDepartmentId()).orElse(null);
            employee.setDepartment(department);
        }

        // Update Cabin
        if (employeeRequest.getCabinId() != null) {
            CabinAllocation cabin = cabinAllocationRepository.findById(employeeRequest.getCabinId()).orElse(null);
            employee.setCabin(cabin);
        }

        employeeRepository.save(employee);
    }

    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public void deleteEmployee(@PathVariable Long id){
        Employee employee =employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("employee id not founded"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeResponse getEmployee(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("employee Id not founded"));
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmailAddress(employee.getEmailAddress());
        employeeResponse.setPosition(employee.getPosition());
        employeeResponse.setStatus(employee.getStatus());
        employeeResponse.setDesignationId(employee.getDesignation().getId());
        employeeResponse.setDepartmentId(employee.getDepartment().getId());
        employeeResponse.setCabinId(employee.getCabin().getId());
        return employeeResponse;
    }

}








