package com.example.sportyshoes.service;

import com.example.sportyshoes.creationparameters.ProductCreationParameters;
import com.example.sportyshoes.entity.ProductEntity;
import com.example.sportyshoes.formdata.ProductFormData;
import com.example.sportyshoes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getProductList(){
        return productRepository.findAll();
    }

    public ProductEntity getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public void addProduct(ProductCreationParameters creationParameters){
        productRepository.save(new ProductEntity(creationParameters.getName(), creationParameters.getCategory()));
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public void updateProduct(ProductCreationParameters creationParameters){
        productRepository.save(new ProductEntity(
                creationParameters.getId(),
                creationParameters.getName(),
                creationParameters.getCategory()));
    }

    public Object getProductFormDataById(Long id) {
        ProductEntity productEntity=productRepository.findById(id).get();
        return new ProductFormData(productEntity.getId(),productEntity.getName(),productEntity.getCategory());
    }
}
