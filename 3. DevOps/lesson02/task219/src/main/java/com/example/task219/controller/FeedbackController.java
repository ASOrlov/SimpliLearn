package com.example.task219.controller;


import com.example.task219.entity.Feedback;
import com.example.task219.repository.FeedbackSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class FeedbackController {
    @Autowired
    FeedbackSpringDataRepository repository;

    @GetMapping({"/", "/addFeedBack"})
    public String getEmpForm(@ModelAttribute("feedBack") Feedback feedBack) {
        return "feedBackForm";
    }

    @PostMapping("/addFeedBack")
    public String saveEmp(@Valid @ModelAttribute("feedBack") Feedback feedBack, BindingResult result, RedirectAttributes ra) {
        repository.save(feedBack);
        ra.addFlashAttribute("savedFeedBack", feedBack);
        return "redirect:/detail";
    }

    @GetMapping("/detail")
    public String detail() {
        return "feedBackDetail";
    }

}
