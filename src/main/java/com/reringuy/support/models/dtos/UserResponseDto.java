package com.reringuy.support.models.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserResponseDto {
    Long id;
    String email;
    String role;
}
