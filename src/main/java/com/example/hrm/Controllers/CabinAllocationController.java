package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.CabinAllocationRequest;
import com.example.hrm.Services.CabinAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/v1/cabin-allocation")
public class CabinAllocationController {
    @Autowired
    CabinAllocationService cabinAllocationService;

    @PostMapping("create-cabin-allocation")
    public ResponseEntity<Object> createCabinAllocation(@RequestBody CabinAllocationRequest cabinAllocationRequest) {
        cabinAllocationService.createCabinAllocation(cabinAllocationRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("cabin Allocation created successfully");
    }

    @PutMapping("update-cabin-allocation/{id}")
    public ResponseEntity<Object> updateCabinAllocation(@PathVariable Long id ,@RequestBody CabinAllocationRequest cabinAllocationRequest) {
        if (!cabinAllocationService.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("department not founded");
        }
        cabinAllocationRequest.setId(id);
        cabinAllocationService.updateCabinAllocation(id,cabinAllocationRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("cabin allocation updated successfully");
    }
    @DeleteMapping("delete-cabin-allocation/{id}")
    public ResponseEntity <Object> deleteCabinAllocation(@PathVariable Long id){
        if(! cabinAllocationService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("cabin allocation id not founded");
        }
        cabinAllocationService.deleteCabinAllocation(id);
        return  ResponseEntity
                .ok("cabin Allocation deleted successfully");
    }
    @GetMapping("get-cabin-allocation/{id}")
    public ResponseEntity <Object> getCabinAllocationById (@PathVariable Long id){
        if(! cabinAllocationService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("cabin Allocation ID not founded");
        }
        return ResponseEntity
                .ok(cabinAllocationService.getCabinAllocationById(id));
    }

}


