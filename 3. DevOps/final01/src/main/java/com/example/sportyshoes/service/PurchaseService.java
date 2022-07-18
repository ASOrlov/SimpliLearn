package com.example.sportyshoes.service;


import com.example.sportyshoes.entity.CategoryEntity;
import com.example.sportyshoes.entity.PurchaseEntity;
import com.example.sportyshoes.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public List<PurchaseEntity> getPurchaseReportByDateIntervalAndCategory(LocalDateTime from, LocalDateTime to, CategoryEntity category){
        return purchaseRepository.getPurchaseReportByDateIntervalAndCategory(from, to, category);
    }


}
