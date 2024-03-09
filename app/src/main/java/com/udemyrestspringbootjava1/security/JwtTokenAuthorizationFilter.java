package com.udemyrestspringbootjava1.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

public class JwtTokenAuthorizationFilter extends OncePerRequestFilter {

    private JwtTokenProvider tokenProvider;

    private HandlerExceptionResolver exceptionResolver;

    public JwtTokenAuthorizationFilter(JwtTokenProvider tokenProvider, HandlerExceptionResolver exceptionResolver) {
        this.tokenProvider = tokenProvider;
        this.exceptionResolver = exceptionResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = tokenProvider.resolveToken((request));
            if (token != null && tokenProvider.validateToken(token)){
                Authentication auth = tokenProvider.getAuthentications(token);
                if (auth != null){
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception ex){
            exceptionResolver.resolveException(request, response, null, ex);
        }
    }
}
