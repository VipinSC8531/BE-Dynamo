package com.vip.springsecurity.controller;

import com.vip.springsecurity.dto.AuthRequest;
import com.vip.springsecurity.entity.Product;
import com.vip.springsecurity.entity.UserInfo;
import com.vip.springsecurity.repository.UserInfoRepository;
import com.vip.springsecurity.service.JwtService;
import com.vip.springsecurity.service.ProductService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    ProductService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome(){
        return " Welcome :)";
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Product get(@PathVariable int id){
        return service.getProduct(id);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGenerateToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            UserInfo userInfo = this.userInfoRepository.findByName(authRequest.getUserName()).get();
            String token = jwtService.generateToken(userInfo);
            return token;
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
