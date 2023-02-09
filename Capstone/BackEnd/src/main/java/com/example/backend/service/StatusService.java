package com.example.backend.service;

import com.example.backend.entity.StatusEntity;
import com.example.backend.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public List<StatusEntity> getAll() {
        return statusRepository.findAll();
    }

}
