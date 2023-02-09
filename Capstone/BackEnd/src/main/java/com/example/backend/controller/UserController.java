package com.example.backend.controller;
import com.example.backend.entity.UserEntity;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @ResponseBody
    @GetMapping("/all")
    //@PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<UserEntity> getAllUsers() {
        List<UserEntity >result=userService.getUsersList();
        for (UserEntity userEntity : result) {
            userEntity.setPassword("");
        }
        return result;
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user) {

        if (!user.getPassword().isEmpty()){
            //user change password
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userService.Save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/new")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @ResponseBody
    public ResponseEntity<?> newUser(@RequestBody UserEntity user) {

      if (!userService.isUserExist(user.getLogin())){
          user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
          userService.Save(user);
          return ResponseEntity.ok(user);
      }
      else{
          return ResponseEntity.badRequest().body("Username is already taken");
      }

    }

}