package com.example.backend.service;

import com.example.backend.entity.TypeOfProblemEntity;
import com.example.backend.repository.TypeOfProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfProblemService {

    @Autowired
    TypeOfProblemRepository typeOfProblemRepository;

    public List<TypeOfProblemEntity> getAll() {
        return typeOfProblemRepository.findAll();
    }

    public TypeOfProblemEntity getTypeOfProblemById(Long id){
        return typeOfProblemRepository.findById(id).get();
    }
}
