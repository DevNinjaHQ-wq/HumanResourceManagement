package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.EmployeeRequest;
import com.example.hrm.Entities.Employee;
import com.example.hrm.Services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("create-employee")
    public ResponseEntity <Object> createEmployee (@RequestBody EmployeeRequest employeeRequest){
        employeeService.createEmployee(employeeRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Employee created successfully");
    }
    @PutMapping("update-employee")
    public ResponseEntity <Object> updateEmployee (@RequestBody EmployeeRequest employeeRequest){
        if (!employeeService.existsById(employeeRequest.getId())) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("department not founded");
        }
        employeeService.updateEmployee(employeeRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("employee updated successfully");
    }

    @DeleteMapping("delete-employee/{id}")
    public ResponseEntity <Object> deleteEmployee(@PathVariable Long id){
        if(! employeeService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("employee id not founded");
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity
                .ok("employee deleted successfully");
    }
    @GetMapping("get-employee{id}")
    public ResponseEntity <Object> getEmployeeById(@PathVariable Long id){
        if(! employeeService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("employee ID not founded");
        }
        return ResponseEntity
                .ok(employeeService.getEmployee(id));
    }

}


