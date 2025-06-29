package com.example.hrm.Repositaries;

import com.example.hrm.Entities.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCardRepository extends JpaRepository<BusinessCard,Long> {
}
