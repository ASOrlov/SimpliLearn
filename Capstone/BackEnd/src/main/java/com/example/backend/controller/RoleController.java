package com.example.backend.controller;
import com.example.backend.entity.RoleEntity;
import com.example.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @ResponseBody
    @GetMapping("/all")
    public List<RoleEntity> displayUsers() {
        return roleService.getRolesList();
    }

}