package com.example.recept_back.service.abstracts;

import com.example.recept_back.model.dto.recept.ReceptRequestDto;
import com.example.recept_back.model.dto.recept.ReceptResponseDto;
import com.example.recept_back.model.entity.Recept;

import java.util.List;
import java.util.Optional;

public interface ReceptService {
    List<ReceptResponseDto> getAllRecepts();

    List<ReceptResponseDto> getAllReceptByUserId(Long id);
    List<ReceptResponseDto> getAllReceptByTagId(Long id);
    Optional<ReceptResponseDto> getReceptById(Long id);
    ReceptResponseDto saveRecept(ReceptRequestDto dto);
    ReceptResponseDto createRecept(ReceptRequestDto dto);

    void deleteRecept(Long id);
}
