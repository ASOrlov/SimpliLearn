package com.example.backend.service;

import com.example.backend.entity.RoleEntity;
import com.example.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<RoleEntity> getRolesList() {
        return roleRepository.findAll();
    }

}
