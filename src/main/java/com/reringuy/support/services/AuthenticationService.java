package com.reringuy.support.services;

import com.reringuy.support.models.dtos.AuthenticationDto;
import com.reringuy.support.models.dtos.LoginResponseDto;
import com.reringuy.support.models.dtos.UserResponseDto;
import com.reringuy.support.models.entities.User;
import com.reringuy.support.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
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

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UserRepository userRepository;

    public LoginResponseDto authentication(AuthenticationDto data) {
        var passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password(), null);
        authenticationManager.authenticate(passwordAuthenticationToken);
        User user = userRepository.findByEmail(data.username()).orElseThrow(EntityNotFoundException::new);

        String token = tokenService.generateToken(user.getUsername());

        return new LoginResponseDto(
                modelMapper.map(user, UserResponseDto.class),
                token
        );
    }
}
