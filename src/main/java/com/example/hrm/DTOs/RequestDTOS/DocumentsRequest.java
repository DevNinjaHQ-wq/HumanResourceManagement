package com.example.hrm.DTOs.RequestDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DocumentsRequest {
    private Long id;
    private String document_type;
    private String file_name;
}
