package com.example.recept_back.model.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private String login;
    private String username;
    private String password;
}
