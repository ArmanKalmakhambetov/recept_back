package com.example.recept_back.controllers;

import com.example.recept_back.model.dto.recept.ReceptRequestDto;
import com.example.recept_back.model.dto.recept.ReceptResponseDto;
import com.example.recept_back.service.abstracts.ReceptService;
import com.example.recept_back.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/recept")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000/"})
public class ReceptAuthRestController {

    private final ReceptService receptService;
    private final UserService userService;


    @GetMapping("/user/auth")
    public List<ReceptResponseDto> getAllReceptByAuthUser(Authentication authentication) {
        String login = authentication.getName();
        Long userId = userService.getUserByLogin(login).get().getUserId();
        return receptService.getAllReceptByUserId(userId);
    }

    @PostMapping("/create")
    public ReceptResponseDto createRecept(@RequestBody ReceptRequestDto dto) {
        return receptService.createRecept(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        receptService.deleteRecept(id);
        return ResponseEntity.ok().build();
    }
}

