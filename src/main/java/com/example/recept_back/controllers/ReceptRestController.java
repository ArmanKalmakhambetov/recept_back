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
@RequestMapping("/api/recept")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000/"})
public class ReceptRestController {

    private final ReceptService receptService;
    private final UserService userService;


    @GetMapping
    public List<ReceptResponseDto> getAll() {
        return receptService.getAllRecepts();
    }

    @GetMapping("/user/{id}")
    public List<ReceptResponseDto> getAllReceptByUserId(@PathVariable Long id) {
        return receptService.getAllReceptByUserId(id);
    }

    @GetMapping("/tag/{id}")
    public List<ReceptResponseDto> getAllReceptByTagId(@PathVariable Long id) {
        return receptService.getAllReceptByTagId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptResponseDto> getById(@PathVariable Long id) {
        return receptService.getReceptById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

