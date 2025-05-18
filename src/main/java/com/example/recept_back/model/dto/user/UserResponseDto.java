package com.example.recept_back.model.dto.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long userid;
    private String login;
    private String username;
}
