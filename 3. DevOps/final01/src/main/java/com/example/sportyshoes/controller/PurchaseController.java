package com.example.sportyshoes.controller;


import com.example.sportyshoes.entity.CategoryEntity;
import com.example.sportyshoes.entity.form.FormFilterPurchase;
import com.example.sportyshoes.entity.form.FormSearchUser;
import com.example.sportyshoes.service.CategoryService;
import com.example.sportyshoes.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/managePurchases")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/makeReport")
    public String getPurchaseSelectFormPage(Model model){
        model.addAttribute("formFilterPurchase",new FormFilterPurchase());
        return "purchaseSelectForm";
    }


    @PostMapping("/show")
    public String getPurchaseR(@ModelAttribute("formFilterPurchase") FormFilterPurchase formFilterPurchase, Model model){
        model.addAttribute("formFilterPurchase",formFilterPurchase);
        model.addAttribute("purchaseList",purchaseService.getPurchaseReportByDateIntervalAndCategory(formFilterPurchase.getFrom(),formFilterPurchase.getTo(),formFilterPurchase.getCategory()));
        return "purchaseReport";
    }

    @ModelAttribute("categoryList")
    public List<CategoryEntity> getCategoryList(){
        return categoryService.getCategoryList();
    }


}
