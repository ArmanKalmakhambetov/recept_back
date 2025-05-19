package com.example.recept_back.controllers;

import com.example.recept_back.model.dto.recept.ReceptRequestDto;
import com.example.recept_back.model.dto.recept.ReceptResponseDto;
import com.example.recept_back.service.abstracts.ReceptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recept")
public class ReceptRestController {

    private final ReceptService receptService;

    public ReceptRestController(ReceptService receptService) {
        this.receptService = receptService;
    }

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

    @PostMapping
    public ReceptResponseDto save(@RequestBody ReceptRequestDto dto) {
        return receptService.saveRecept(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptResponseDto> getById(@PathVariable Long id) {
        return receptService.getReceptById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        receptService.deleteRecept(id);
        return ResponseEntity.ok().build();
    }
}

