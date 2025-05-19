package com.example.recept_back.service.abstracts;

import com.example.recept_back.model.dto.recept.ReceptResponseDto;
import com.example.recept_back.model.dto.user.UserRequestDto;
import com.example.recept_back.model.dto.user.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    Optional<UserResponseDto> getUserById(Long id);
    UserResponseDto saveUser(UserRequestDto userRequestDto);
    void deleteUser(Long id);

}
