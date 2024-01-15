package com.canalhas.project.springbootbook.service;

import com.canalhas.project.springbootbook.dto.JwtAuthenticationResponse;
import com.canalhas.project.springbootbook.dto.RefreshTokenRequest;
import com.canalhas.project.springbootbook.dto.SignUpRequest;
import com.canalhas.project.springbootbook.dto.SigninRequest;
import com.canalhas.project.springbootbook.model.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
