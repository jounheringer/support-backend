package com.reringuy.support.controllers;

import com.reringuy.support.models.dtos.AuthenticationDto;
import com.reringuy.support.models.dtos.LoginResponseDto;
import com.reringuy.support.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid AuthenticationDto data) {
        LoginResponseDto reponse = authenticationService.authentication(data);
        return ResponseEntity.ok().body(reponse);
    }
}
