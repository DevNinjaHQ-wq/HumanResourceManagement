package com.example.hrm.Services.serviceimplementation;
import com.example.hrm.DTOs.RequestDTOS.DocumentsRequest;
import com.example.hrm.DTOs.ResponseDTOS.DocumentsResponse;
import com.example.hrm.Entities.Documents;
import com.example.hrm.Repositaries.DocumentRepository;
import com.example.hrm.Services.DocumentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DocumentServiceImplementation implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void createDocuments (DocumentsRequest documentsRequest){
        Documents document=new Documents();
        document.setDocumentType(documentsRequest.getDocument_type());
        document.setFileName(documentsRequest.getFile_name());
        documentRepository.save(document);
    }
    @Override
    public void updateDocuments(Long id,DocumentsRequest documentsRequest){
        Documents document= documentRepository.findById(documentsRequest.getId())
                .orElseThrow(()-> new RuntimeException("documentID not found"));
        document.setDocumentType(documentsRequest.getDocument_type());
        document.setFileName(documentsRequest.getFile_name());
        documentRepository.save(document);
    }
    @Override
    public boolean existsById(Long id){
        return documentRepository.existsById(id);

    }
    @Override
    public void deleteDocuments(@PathVariable Long id){
        Documents document=documentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("document id not founded"));
        documentRepository.delete(document);
    }

    @Override
    public DocumentsResponse getDocumentById(@PathVariable Long id){
        Documents documents = documentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("document ID not founded"));
        DocumentsResponse documentsResponse = new DocumentsResponse();
        documentsResponse.setId(documents.getId());
        documentsResponse.setDocument_type(documents.getDocumentType());
        documentsResponse.setFile_name(documents.getFileName());
        documentsResponse.setDocument_type(documents.getDocumentType());
        return documentsResponse;
    }


}
