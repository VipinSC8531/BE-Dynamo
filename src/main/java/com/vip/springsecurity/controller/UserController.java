package com.vip.springsecurity.controller;

import com.vip.springsecurity.entity.UserInfo;
import com.vip.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserInfo saveUser(@RequestBody UserInfo user){
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserInfo getUser(@PathVariable("id") long id){
        return service.getUser(id);
    }

    @GetMapping("/")
    public List<UserInfo> getAllUsers(){
        return service.getAll();
    }
}
