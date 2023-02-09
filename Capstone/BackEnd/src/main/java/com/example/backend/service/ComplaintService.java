package com.example.backend.service;

import com.example.backend.entity.ComplaintEntity;
import com.example.backend.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    public List<ComplaintEntity> getAll() {
        return complaintRepository.findAll();
    }

    public void Save(ComplaintEntity complaintEntity) {
        complaintRepository.save(complaintEntity);
    }

}
