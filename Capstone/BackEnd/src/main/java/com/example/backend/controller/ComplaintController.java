package com.example.backend.controller;

import com.example.backend.entity.ComplaintEntity;
import com.example.backend.service.ComplaintService;
import com.example.backend.service.TypeOfProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;
    @Autowired
    TypeOfProblemService typeOfComplaintService;

    @ResponseBody
    @GetMapping("/all")
    public List<ComplaintEntity> getAllComplaints() {
        List<ComplaintEntity>result=complaintService.getAll();
        return result;
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateComplaint(@RequestBody ComplaintEntity complaint) {
        complaintService.Save(complaint);
        return ResponseEntity.ok(complaint);
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<?> newComplaint(@RequestBody ComplaintEntity complaint) {
        System.out.println(complaint);
        complaintService.Save(complaint);
        return ResponseEntity.ok(complaint);
    }
}
