package com.reringuy.support.models.dtos;

public record UserResponseDto(
        Long id,
        String email,
        String role
) {}
