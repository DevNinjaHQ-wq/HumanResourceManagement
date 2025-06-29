package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.DepartmentRequest;
import com.example.hrm.DTOs.RequestDTOS.DesignationRequest;
import com.example.hrm.Services.Designationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/designation")
public class DesignationController {
    @Autowired
    Designationservice designationservice;

    @PostMapping("create-designation")
    public ResponseEntity<Object> createDesignation(@RequestBody DesignationRequest designationRequest){
        designationservice.createDesignation(designationRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Designation created successfully");

    }
    @PutMapping("update-designation/{id}")
    public ResponseEntity <Object> updateDesignation(@PathVariable Long id,@RequestBody DesignationRequest designationRequest){
        if(!designationservice.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("designation  ID not found");
        }
        designationRequest.setId(id);
        designationservice.updateDesignation(id,designationRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("designation updated sucessfully");
    }

    @DeleteMapping("delete-designation/{id}")
    public ResponseEntity <Object> deleteDesignation(@PathVariable Long id){
        if(!designationservice.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("designation id not founded");
        }
        designationservice.deleteDesignation(id);
        return ResponseEntity
                .ok("designation deleted successfully");
    }

    @GetMapping("getDesignation/{id}")
    public ResponseEntity <Object> getDesignationById(@PathVariable Long id){
        if(!designationservice.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("designation ID not founded");
        }
        return ResponseEntity
                .ok(designationservice.getDesignationById(id));
    }
}
