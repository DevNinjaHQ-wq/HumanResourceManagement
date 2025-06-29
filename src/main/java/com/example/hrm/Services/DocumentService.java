package com.example.hrm.Services;

import com.example.hrm.DTOs.RequestDTOS.DocumentsRequest;
import com.example.hrm.DTOs.ResponseDTOS.DocumentsResponse;

public interface DocumentService {
    public void createDocuments(DocumentsRequest documentsRequest);
    public void updateDocuments(Long id,DocumentsRequest documentsRequest);
    public boolean existsById( Long id);
    public void deleteDocuments(Long id);
    public DocumentsResponse getDocumentById(Long id);

}
