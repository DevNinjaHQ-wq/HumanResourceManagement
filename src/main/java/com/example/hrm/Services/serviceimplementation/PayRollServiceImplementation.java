package com.example.hrm.Services.serviceimplementation;

import com.example.hrm.DTOs.RequestDTOS.PayRollRequest;
import com.example.hrm.DTOs.ResponseDTOS.PayRollResponse;
import com.example.hrm.Entities.Employee;
import com.example.hrm.Entities.PayRoll;
import com.example.hrm.Repositaries.EmployeeRepository;
import com.example.hrm.Repositaries.PayRollRepository;
import com.example.hrm.Services.PayRollService;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PayRollServiceImplementation implements PayRollService {
    @Autowired
    PayRollRepository payRollRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createPayRoll(@RequestBody PayRollRequest payRollRequest){
        Employee employee = employeeRepository.findById(payRollRequest.getEmployee_id())
                .orElseThrow(()-> new RuntimeException("Employee not found"));
        PayRoll payroll=new PayRoll();
        payroll.setMonth(payRollRequest.getMonth());
        payroll.setBasicSalary(payRollRequest.getBasicSalary());
        payroll.setDeduction(payRollRequest.getDeduction());
        payroll.setNetPay(payRollRequest.getNetPay());
        payroll.setEmployee(employee);
        payRollRepository.save(payroll);
    }

    @Override
    public void updatePayRoll(Long id,@RequestBody PayRollRequest payRollRequest){
        PayRoll payRoll =payRollRepository.findById(payRollRequest.getId())
                .orElseThrow(()->new RuntimeException("payroll id not founded"));
        payRoll.setMonth(payRollRequest.getMonth());
        payRoll.setBasicSalary(payRollRequest.getBasicSalary());
        payRoll.setDeduction(payRollRequest.getDeduction());
        payRoll.setNetPay(payRoll.getNetPay());
        payRollRepository.save(payRoll);
    }

    @Override
    @Transactional
    public boolean existsById(Long id){
        return payRollRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deletePayRoll (@PathVariable Long id){
        //PayRoll payRoll = payRollRepository.findById(id)
               // .orElseThrow(()-> new RuntimeException("payroll ID not founded"));
        payRollRepository.deleteById(id);
    }

    @Override
    public PayRollResponse getPayRoll (@PathVariable Long id){
        PayRoll payRoll = payRollRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("PayRoll ID not found"));
        PayRollResponse payRollResponse = new PayRollResponse();
        payRollResponse.setId(payRoll.getId());
        payRollResponse.setMonth(payRoll.getMonth());
        payRollResponse.setBasicSalary(payRoll.getBasicSalary());
        payRollResponse.setDeduction(payRoll.getDeduction());
        payRollResponse.setNetPay(payRoll.getNetPay());
        payRollResponse.setEmployee_id(payRoll.getEmployee().getId());
        return payRollResponse;

    }
}
