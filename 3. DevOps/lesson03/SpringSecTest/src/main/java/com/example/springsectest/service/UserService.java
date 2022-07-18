package com.example.springsectest.service;

import com.example.springsectest.entity.RoleEntity;
import com.example.springsectest.entity.UserEntity;
import com.example.springsectest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean isUserAuthorised(String login, String password){

        UserEntity userEntity=userRepository.findUserEntityByLogin(login);

        if (userEntity==null) return false;

        if (userEntity.getPassword().equals(password))
            return true;
        else
            return false;

    }

    public RoleEntity getUserRole(String login){

        UserEntity userEntity=userRepository.findUserEntityByLogin(login);

        if (userEntity==null)
            return null;
        else
            return userEntity.getPermissionLevel();

    }

    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

  }
