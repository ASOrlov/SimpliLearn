package com.test.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/webapi")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allproduct")
    public List<ProductEntity> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public ProductEntity getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody ProductEntity pe ) {
        productService.addProduct(pe);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProductEntity pe ) {
        productService.updateProduct(id, pe);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id)  {
        productService.deleteProduct(id);
    }
}
