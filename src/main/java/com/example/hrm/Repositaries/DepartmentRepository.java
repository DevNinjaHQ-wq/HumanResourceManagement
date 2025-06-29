package com.example.hrm.Repositaries;

import com.example.hrm.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department,Long> {

}
