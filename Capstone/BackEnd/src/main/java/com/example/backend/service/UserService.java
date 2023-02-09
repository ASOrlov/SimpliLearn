package com.example.backend.service;

import com.example.backend.entity.RoleEntity;
import com.example.backend.entity.UserEntity;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    public boolean isUserExist(String login){
        UserEntity userEntity=userRepository.findUserEntityByLogin(login);
        if (userEntity==null)
            return false;
        else
            return true;
    }




    public RoleEntity getUserRole(String login){

        UserEntity userEntity=userRepository.findUserEntityByLogin(login);

        if (userEntity==null)
            return null;
        else
            return userEntity.getRole();

    }

    public List<UserEntity> getUsersList() {
        return userRepository.findAll();
    }

    public void Save(UserEntity user) {
        userRepository.save(user);
    }
}
