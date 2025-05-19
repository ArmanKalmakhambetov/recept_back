package com.example.recept_back.model.dto.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long userId;
    private String login;
    private String username;
}
