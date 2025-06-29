package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.LabAllocationRequest;
import com.example.hrm.Services.LabAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/lab-allocation")
public class LabAllocationController {

    @Autowired
    LabAllocationService labAllocationService;

    @PostMapping("create-lab-allocation")
    public ResponseEntity <Object> createLabAllocation (@RequestBody LabAllocationRequest labAllocationRequest){
        labAllocationService.createLabAllocation(labAllocationRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Lab Allocated successfully");
    }
    @PutMapping("update-lab-allocation/{id}")
    public ResponseEntity <Object> updateLabAllocation (@PathVariable Long id,@RequestBody LabAllocationRequest labAllocationRequest){
        if(! labAllocationService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("lab allocation id not found");
        }
        labAllocationRequest.setId(id);
        labAllocationService.updateLabAllocation(id,labAllocationRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("lab allocation updated successfully");
    }
    public boolean existsById(Long id){
        return labAllocationService.existsById(id);
    }

    @DeleteMapping("delete-lab-allocation/{id}")
    public ResponseEntity <Object> deleteLabAllocation(@PathVariable Long id){
        if(! labAllocationService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("laballocation id not founded");
        }
        labAllocationService.deleteLabAllocation(id);
        return ResponseEntity
                .ok("lab allocation deleted successfully");
    }

    @GetMapping("get-lab-allocation/{id}")
    public ResponseEntity <Object> getLabAllocationById(@PathVariable Long id ){
        if(! labAllocationService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("lab Allocation ID not founded");
        }
        return ResponseEntity
                .ok(labAllocationService.getLabAllocationById(id));
    }
}
