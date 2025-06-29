package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.DepartmentRequest;
import com.example.hrm.DTOs.ResponseDTOS.DepartmentResponse;
import com.example.hrm.Services.Departmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

    @Autowired
    Departmentservice departmentservice;

    @PostMapping("create-department")
    public ResponseEntity<Object> createDepartment(@RequestBody DepartmentRequest departmentRequest){
        departmentservice.createDepartment(departmentRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Department created successfully");
    }

    @PutMapping("update-department/{id}")
    public ResponseEntity<Object> updateDepartment (@PathVariable Long id ,@RequestBody DepartmentRequest departmentRequest){
        if(!departmentservice.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("department not founded");
        }
        departmentRequest.setId(id);
        departmentservice.updateDepartment( id,departmentRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Department updated successfully");
    }
    @DeleteMapping("delete-department/{id}")
    public ResponseEntity<Object> deleteDepartment (@PathVariable Long id){
        if(!departmentservice.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("department Not Found");
        }

        departmentservice.deleteDepartment(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Department Deleted successfully");
    }
    @GetMapping("get-department/{id}")
    public ResponseEntity <Object> getDepartmentById (@PathVariable Long id){
        if(!departmentservice.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("department is not founded");
        }
        return ResponseEntity
                .ok(departmentservice.getDepartmentById(id));

    }
    @GetMapping("get-all-department")
    public ResponseEntity <List<DepartmentResponse>> getAllDepartment(){
        return ResponseEntity
                .ok(departmentservice.getAllDepartment());
    }






}
