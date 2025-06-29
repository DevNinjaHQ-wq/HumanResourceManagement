package com.example.hrm.Repositaries;

import com.example.hrm.Entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Documents,Long> {
}
