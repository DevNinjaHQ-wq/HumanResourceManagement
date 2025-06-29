package com.example.hrm.Repositaries;

import com.example.hrm.Entities.PayRoll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRollRepository extends JpaRepository <PayRoll,Long> {
}
