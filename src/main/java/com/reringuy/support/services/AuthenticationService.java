package com.reringuy.support.services;

import com.reringuy.support.models.dtos.AuthenticationDto;
import com.reringuy.support.models.dtos.LoginResponseDto;
import com.reringuy.support.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public LoginResponseDto authentication(AuthenticationDto data) {
        var user = new UsernamePasswordAuthenticationToken(data.username(), data.password(), null);
        var auth = (User) authenticationManager.authenticate(user);

        String token = tokenService.generateToken(auth.getUsername());

        return new LoginResponseDto(token);
    }
}
