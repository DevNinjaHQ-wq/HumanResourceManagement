package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.BusinessCardRequest;
import com.example.hrm.DTOs.ResponseDTOS.BusinessCardResponse;
import com.example.hrm.DTOs.ResponseDTOS.DepartmentResponse;
import com.example.hrm.Entities.BusinessCard;
import com.example.hrm.Entities.Department;
import com.example.hrm.Repositaries.BusinessCardRepository;
import com.example.hrm.Repositaries.EmployeeRepository;
import com.example.hrm.Services.BusinessCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class BusinessCardServiceImplementation implements BusinessCardService {
    @Autowired
    BusinessCardRepository businessCardRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createBusinessCard(@RequestBody BusinessCardRequest businessCardRequest) {
        BusinessCard businessCard = new BusinessCard();
        businessCard.setName(businessCardRequest.getName());
        businessCard.setTitle(businessCardRequest.getTitle());
        businessCard.setEmail(businessCardRequest.getEmail());
        businessCard.setPhone(businessCard.getPhone());
        businessCard.setCompany(businessCard.getCompany());
        businessCardRepository.save(businessCard);
    }

    @Override
    public void updateBusinessCard(Long id,@RequestBody BusinessCardRequest businessCardRequest) {
        BusinessCard businessCard = businessCardRepository.findById(businessCardRequest.getId())
                .orElseThrow(() -> new RuntimeException("Business card not found"));

        businessCard.setName(businessCardRequest.getName());
        businessCard.setTitle(businessCardRequest.getTitle());
        businessCard.setEmail(businessCardRequest.getEmail());
        businessCard.setPhone(businessCardRequest.getPhone());
        businessCard.setCompany(businessCardRequest.getCompany());
        businessCardRepository.save(businessCard);
    }

    @Override
    public boolean existsById(Long id) {
        return businessCardRepository.existsById(id);
    }

    @Override
    public void deleteBusinessCard(@PathVariable Long id) {
        BusinessCard businessCard = businessCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BusinessCard not founded"));
        businessCardRepository.delete(businessCard);
    }

    @Override
    public BusinessCardResponse getBusinessCardById (Long id){
        BusinessCard businessCard = businessCardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Business card not founded"));
        BusinessCardResponse businessCardResponse = new BusinessCardResponse();
        businessCardResponse.setId(businessCard.getId());
        businessCardResponse.setName(businessCard.getName());
        businessCardResponse.setTitle(businessCard.getTitle());
        businessCardResponse.setEmail(businessCard.getEmail());
        businessCardResponse.setPhone(businessCard.getPhone());
        businessCardResponse.setCompany(businessCard.getCompany());
        businessCardResponse.setEmployee_id(businessCard.getId());
        return businessCardResponse;
    }
}
