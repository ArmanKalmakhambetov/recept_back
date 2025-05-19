package com.example.recept_back.service.impl;

import com.example.recept_back.model.dto.user.UserRequestDto;
import com.example.recept_back.model.dto.user.UserResponseDto;
import com.example.recept_back.model.entity.User;
import com.example.recept_back.repo.UserRepo;
import com.example.recept_back.service.abstracts.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserResponseDto> getUserById(Long id) {
        return userRepo.findById(id).map(this::toDto);
    }

    @Override
    @Transactional
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setLogin(userRequestDto.getLogin());
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        User savedUser = userRepo.save(user);
        return toDto(savedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Optional<UserResponseDto> getUserByLogin(String login) {
        return Optional.of(toDto(userRepo.findUserByLogin(login)));
    }

    private UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(user.getId());
        dto.setLogin(user.getLogin());
        dto.setUsername(user.getUsername());
        return dto;
    }
}
