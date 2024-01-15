package com.canalhas.project.springbootbook.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {


    String extractUserName(String token);



    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(UserDetails userDetails);


    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}
