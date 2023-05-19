package com.vip.springsecurity.service;

import com.vip.springsecurity.entity.UserInfo;
import com.vip.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    PasswordEncoder encoder;

    public UserInfo saveUser(UserInfo user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserInfo getUser(Long userId){
        return repository.getReferenceById(userId);
    }

    public List<UserInfo> getAll() {
        return repository.findAll();
    }
}
