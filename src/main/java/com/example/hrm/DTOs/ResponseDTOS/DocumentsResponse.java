package com.example.hrm.DTOs.ResponseDTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentsResponse {
    private Long id;
    private String document_type;
    private String file_name;
}
