package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.DepartmentRequest;
import com.example.hrm.DTOs.ResponseDTOS.DepartmentResponse;
import com.example.hrm.Entities.Department;
import com.example.hrm.Repositaries.DepartmentRepository;
import com.example.hrm.Services.Departmentservice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImplementation implements Departmentservice {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void createDepartment (DepartmentRequest departmentRequest){
        Department department=new Department();
        department.setLocation(departmentRequest.getLocation());
        department.setName(departmentRequest.getName());
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Long id,DepartmentRequest departmentRequest){
        Department department=departmentRepository.findById(departmentRequest.getId())
                .orElseThrow(() -> new RuntimeException("department not found"));
        department.setId(departmentRequest.getId());
        department.setName(departmentRequest.getName());
        department.setLocation(departmentRequest.getLocation());

        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id){
        Department department=departmentRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("department not found"));

        departmentRepository.delete(department);
    }


    @Override
    public boolean existsById(Long id){
         return departmentRepository.existsById(id);

    }
    @Override
    public DepartmentResponse getDepartmentById(Long id){
        Department department=departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("department id not founded"));
        DepartmentResponse departmentResponse= new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        departmentResponse.setLocation(department.getLocation());
        return departmentResponse;
    }
    @Override
    public List<DepartmentResponse> getAllDepartment(){
        List<Department> departmentList= departmentRepository.findAll();
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        for(Department department : departmentList){
            DepartmentResponse departmentResponse = new DepartmentResponse();
            departmentResponse.setId(department.getId());
            departmentResponse.setName(department.getName());
            departmentResponse.setLocation(department.getLocation());
            departmentResponses.add(departmentResponse);
        }
        return departmentResponses;

    }

}







