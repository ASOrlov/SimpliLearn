package com.example.backend.controller;

import com.example.backend.entity.StatusEntity;
import com.example.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/all")
    public List<StatusEntity> getAllStatuses() {

        List<StatusEntity >result=statusService.getAll();

        return result;
    }

}
