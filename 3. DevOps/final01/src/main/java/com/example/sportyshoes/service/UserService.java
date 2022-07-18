package com.example.sportyshoes.service;

import com.example.sportyshoes.entity.RoleEntity;
import com.example.sportyshoes.entity.UserEntity;
import com.example.sportyshoes.entity.form.FormChangePassword;
import com.example.sportyshoes.repository.UserRepository;
import com.example.sportyshoes.security.util.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    public boolean changePassword(FormChangePassword formChangePassword, Principal principal) {
        MyUserDetails myUserDetails =((MyUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());


        if (bCryptPasswordEncoder.matches(formChangePassword.getOldPassword(),myUserDetails.getPassword())
        && formChangePassword.getNewPassword().equals(formChangePassword.getConfirmNewPassword())) {

            UserEntity user=userRepository.findUserEntityByLogin(myUserDetails.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(formChangePassword.getNewPassword()));
            userRepository.save(user);

            return true;
        }
        return false;

    }

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

    public List<UserEntity> findUsersWithPartOfName(String name){
        return userRepository.findUsersWithPartOfName("%"+name+"%",Sort.by("login"));
    }
}
