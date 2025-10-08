package com.reringuy.support.controllers;

import com.reringuy.support.models.dtos.AuthenticationDto;
import com.reringuy.support.models.dtos.LoginResponseDto;
import com.reringuy.support.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
class AuthController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid AuthenticationDto data) {
        try {
            LoginResponseDto reponse = authenticationService.authentication(data);

            return ResponseEntity.ok().body(reponse);
        } catch (Exception e) {
            log.error("Erro ao autenticar usuario", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
