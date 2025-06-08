package com.reringuy.support.models.dtos;

public record LoginResponseDto(
        UserResponseDto user,
        String token
){}