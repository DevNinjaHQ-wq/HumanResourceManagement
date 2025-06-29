package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.PayRollRequest;
import com.example.hrm.Repositaries.EmployeeRepository;
import com.example.hrm.Repositaries.PayRollRepository;
import com.example.hrm.Services.EmployeeService;
import com.example.hrm.Services.PayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payroll")
public class PayRollController {
    @Autowired
    PayRollService payRollService;

    @PostMapping("create-payroll")
    public ResponseEntity <Object> createPayRoll (@RequestBody PayRollRequest payRollRequest){
        payRollService.createPayRoll(payRollRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Payroll has been created");
    }
    @PutMapping("update-payroll/{id}")
    public ResponseEntity <Object> updatePayRoll (@PathVariable Long id,@RequestBody PayRollRequest payRollRequest){
        if(! payRollService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("payroll id not founded");
        }
        payRollRequest.setId(id);
        payRollService.updatePayRoll(id,payRollRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("payroll updated successfully");
    }

    @DeleteMapping("delete-payroll/{id}")
    public ResponseEntity <Object> deletePayRoll(@PathVariable Long id){
        if(! payRollService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("PayRoll ID not founded");
        }
        payRollService.deletePayRoll(id);
        return ResponseEntity
                .ok("PayRoll Deleted Successfully");

    }

    @GetMapping("get-payroll/{id}")
    public ResponseEntity <Object> getPayRoll (@PathVariable Long id){
        if(!payRollService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("pay roll ID not founded");
        }
        return ResponseEntity
                .ok(payRollService.getPayRoll(id));
    }
}
