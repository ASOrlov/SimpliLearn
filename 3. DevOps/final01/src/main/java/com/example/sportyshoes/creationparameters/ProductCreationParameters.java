package com.example.sportyshoes.creationparameters;

import com.example.sportyshoes.entity.CategoryEntity;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter

public class ProductCreationParameters {

    Long id;

    private String name;
    private CategoryEntity category;

    public ProductCreationParameters(String name, CategoryEntity category, Long id) {

        Assert.notNull(name, "Name should not be null");
        Assert.notNull(category, "Category should not be null");

        this.id = id;
        this.name = name;
        this.category = category;
    }
}

