package com.example.sportyshoes.formdata;

import com.example.sportyshoes.creationparameters.ProductCreationParameters;
import com.example.sportyshoes.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFormData {

    Long id;

    @NotNull
    @Size(min = 1, max = 400)
    private String name;

    @NotNull
    private CategoryEntity category;

    public ProductCreationParameters toParameters() {
        return new ProductCreationParameters(name, category, id);
    }

}
