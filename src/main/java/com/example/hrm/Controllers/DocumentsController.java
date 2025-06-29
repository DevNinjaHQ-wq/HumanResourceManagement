package com.example.hrm.Controllers;

import com.example.hrm.DTOs.RequestDTOS.DocumentsRequest;
import com.example.hrm.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/documents")
public class DocumentsController {
    @Autowired
    DocumentService documentService;

    @PostMapping("create-documents")
    public ResponseEntity <Object> createDocuments (@RequestBody DocumentsRequest documentsRequest){
        documentService.createDocuments(documentsRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Document created successfully");
    }

    @PutMapping("update-documents/{id}")
    public ResponseEntity<Object> updateDocuments (@PathVariable Long id ,@RequestBody DocumentsRequest documentsRequest){
        if(!documentService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("department not founded");
        }
        documentsRequest.setId(id);
        documentService.updateDocuments(id,documentsRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("document updated successfully");
    }

    @DeleteMapping("delete-documents/{id}")
    public ResponseEntity <Object> deleteDocument (@PathVariable Long id){
        if(! documentService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("document id not founded");
        }
        documentService.deleteDocuments(id);
        return ResponseEntity
                .ok("document deleted successfully");
    }

    @GetMapping("get-document/{id}")
    public ResponseEntity <Object> getDocumentById (@PathVariable Long id){
        if(!documentService.existsById(id)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("document id not founded");
        }
        return ResponseEntity
                .ok(documentService.getDocumentById(id));
    }

}
