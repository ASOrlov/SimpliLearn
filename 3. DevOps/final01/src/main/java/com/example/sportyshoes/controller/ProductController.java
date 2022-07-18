package com.example.sportyshoes.controller;

import com.example.sportyshoes.entity.CategoryEntity;
import com.example.sportyshoes.entity.ProductEntity;
import com.example.sportyshoes.formdata.ProductFormData;
import com.example.sportyshoes.service.CategoryService;
import com.example.sportyshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/manageProducts")
@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;



    @GetMapping("/main")
    public String getProductsPage(Model model){
        model.addAttribute("productFormData",new ProductFormData());
        return "manageProducts";
    }

    @GetMapping("/actions{id}")
    public String getProductActionsPage(@PathVariable("id") Long id, Model model){

        model.addAttribute("productFormData",productService.getProductFormDataById(id));
        return "productActions";
    }

    @PostMapping("/delete{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "redirect:/manageProducts/main";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("productFormData") ProductFormData productFormData, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "manageProducts/main";
        }
        productService.updateProduct(productFormData.toParameters());

        return "redirect:/manageProducts/main";
    }

    @PostMapping({"/addProduct"})
    public String getLoginPage(@Valid @ModelAttribute("productFormData") ProductFormData productFormData, BindingResult bindingResult, Model model){


        if (bindingResult.hasErrors()) {
            return "manageProducts/main";
        }
        productService.addProduct(productFormData.toParameters());

        return "redirect:/manageProducts/main";
    }

    @ModelAttribute("categoryList")
    public List<CategoryEntity> getCategoryList(){
        return categoryService.getCategoryList();
    }

    @ModelAttribute("productList")
    public List<ProductEntity> getProductList(){
        return productService.getProductList();
    }


}
