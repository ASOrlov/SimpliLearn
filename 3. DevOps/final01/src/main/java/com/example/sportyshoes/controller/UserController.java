package com.example.sportyshoes.controller;

import java.security.Principal;
import com.example.sportyshoes.entity.UserEntity;
import com.example.sportyshoes.entity.form.FormChangePassword;
import com.example.sportyshoes.entity.form.FormSearchUser;
import com.example.sportyshoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/manageUsers")
@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/main")
    public String getUsersPage(Model model){
        model.addAttribute("formSearchUser",new FormSearchUser());
        return "browseUsers";
    }

    @GetMapping("/changePassword")
    public String getUsersChangePasswordPage(Model model){
        model.addAttribute("formChangePassword",new FormChangePassword());
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String getSuccessChangePasswordPage(@ModelAttribute FormChangePassword formChangePassword, Principal principal){
        if (userService.changePassword(formChangePassword,principal))
            return "passwordChangedSuccessfully";
        else return "error";
    }


    @PostMapping("/search")
    public String getUsersPage(@ModelAttribute FormSearchUser formSearchUser, Model model){
        List<UserEntity> foundUsers=userService.findUsersWithPartOfName(formSearchUser.getName());
        model.addAttribute("foundUsers",foundUsers);
        return "foundUsers";
    }

    @ModelAttribute("userList")
    public List<UserEntity> getUserList(){
        return userService.getUserList();
    }


}
