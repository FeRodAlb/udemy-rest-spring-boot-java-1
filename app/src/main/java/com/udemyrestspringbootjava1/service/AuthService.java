package com.udemyrestspringbootjava1.service;

import com.udemyrestspringbootjava1.repository.UserRepository;
import com.udemyrestspringbootjava1.security.JwtTokenProvider;
import com.udemyrestspringbootjava1.security.dto.AccountCredentialsDTO;
import com.udemyrestspringbootjava1.security.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository repository;

    public TokenDTO signin(AccountCredentialsDTO dto){

        try {
            var username = dto.getUsername();
            var password = dto.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var user = repository.findByUsername(username);
            if (user != null){
                return tokenProvider.createAccessToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }
        }
        catch (Exception ex){
            throw new BadCredentialsException("Invalid username/password!");
        }
    }


}
