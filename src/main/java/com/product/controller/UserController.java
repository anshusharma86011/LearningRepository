package com.product.controller;

import com.product.entity.User;
import com.product.service.MyUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private MyUserDetailService myUserDetailService;

    @PostMapping("/register")

    public com.product.entity.User Register(@RequestBody User user)
    {
       return myUserDetailService.createUser(user);
    }


}
