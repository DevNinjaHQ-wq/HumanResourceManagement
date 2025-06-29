package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.BusinessCardRequest;
import com.example.hrm.DTOs.ResponseDTOS.BusinessCardResponse;
import com.example.hrm.DTOs.ResponseDTOS.EmployeeResponse;
import org.springframework.web.bind.annotation.ResponseBody;

public interface BusinessCardService {
    public void createBusinessCard(BusinessCardRequest businessCardRequest);
    public void updateBusinessCard(Long id,BusinessCardRequest businessCardRequest);
    public boolean existsById(Long id);
    public void deleteBusinessCard(Long id);
    public BusinessCardResponse getBusinessCardById (Long id);

}
