package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.BusinessCardRequest;
import com.example.hrm.Services.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/b-card")
public class BusinessCardController {
    @Autowired
    BusinessCardService businessCardService;

    @PostMapping("create-b-card")
    public ResponseEntity <Object>  createBusinessCard(@RequestBody BusinessCardRequest businessCardRequest){
        businessCardService.createBusinessCard(businessCardRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("BusinessCard created successfully");
    }

    @PutMapping("update-b-card/{id}")
    public ResponseEntity<Object> updateBusinessCard(@PathVariable Long id ,@RequestBody BusinessCardRequest businessCardRequest){
        if (!businessCardService.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("businesscard not founded");
        }
        businessCardRequest.setId(id);
        businessCardService.updateBusinessCard(id,businessCardRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Businesscard  Id updated successfully");
    }

    @DeleteMapping("delete-businesscard/{id}")
    public ResponseEntity <Object> deleteBusinessCard(@PathVariable Long id){
        if(!businessCardService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Bisinesscard not founded");
        }
        businessCardService.deleteBusinessCard(id);
        return ResponseEntity
                .ok("Department deleted successfully");
    }
    @GetMapping("get-business card/{id}")
    public ResponseEntity <Object> getBusinessCardById(@PathVariable Long id){
        if(! businessCardService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Business card ID not founded");
        }
        return ResponseEntity
                .ok(businessCardService.getBusinessCardById(id));

    }


}
