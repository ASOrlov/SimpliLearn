package alex.controller;


import alex.model.Category;
import alex.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller

public class ProductContriller {


    @GetMapping("/getProductForm")
    public String getProductForm(@ModelAttribute("prod")Product product,Model model){
        System.out.println("Inside getProduct() ....");
        System.out.println(model.asMap().get("categoryList"));
        return "productForm";
    }

    @GetMapping("/a")
    public String getA(Model model){
        System.out.println("Inside getA() ....");
        System.out.println(model.asMap().get("categoryList"));
        return "productForm";
    }

    @GetMapping("/b")
    public String getB(Model model){
        System.out.println("Inside getB() ....");
        System.out.println(model.asMap().get("categoryList"));
        return "productForm";
    }

    @ModelAttribute("categoryList")
    public List<Category> getCategoryList(){
        List<Category> categories= Arrays.asList(
                new Category(1, "Computer"),
                new Category(2,"Laptop")
        );
        return categories;
    }

}
