package com.udemyrestspringbootjava1.controller;

import com.udemyrestspringbootjava1.security.dto.AccountCredentialsDTO;
import com.udemyrestspringbootjava1.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsDTO dto){
        var token = authService.signin(dto);
        return ResponseEntity.ok(token);
    }

}
