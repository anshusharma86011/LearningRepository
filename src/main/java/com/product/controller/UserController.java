package com.product.controller;

import com.product.dto.UsetDto;
import com.product.entity.User;
import com.product.security.JwtUtil;
import com.product.service.MyUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private MyUserDetailService myUserDetailService;

    @PostMapping("/register")

    public  User Register(@RequestBody User user)
    {
       return myUserDetailService.createUser(user);
    }

    @PostMapping("/login")
    public String  login(@RequestBody UsetDto user )
    {
     Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        List<String> roles = authenticate.getAuthorities()
                             .stream()
                           .map(GrantedAuthority::getAuthority)
//                          .filter(role -> role.startsWith("ROLE_"))
                           .toList();

      UserDetails userDetails = myUserDetailService.loadUserByUsername(user.getUsername());

      return   jwtUtil.generateToken(userDetails.getUsername(), roles);

    }

}
