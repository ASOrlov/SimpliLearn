package com.example.sportyshoes.service;

import com.example.sportyshoes.entity.CategoryEntity;
import com.example.sportyshoes.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategoryList(){
        return categoryRepository.findAll();
    }


}
