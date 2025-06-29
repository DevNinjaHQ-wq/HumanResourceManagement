package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.PayRollRequest;
import com.example.hrm.DTOs.ResponseDTOS.PayRollResponse;

public interface PayRollService {
    public void createPayRoll(PayRollRequest payRollRequest);
    public void updatePayRoll(Long id,PayRollRequest payRollRequest);
    public boolean existsById(Long id);
    public void deletePayRoll(Long id);
    public PayRollResponse getPayRoll(Long id);
}
