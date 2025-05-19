package com.example.recept_back.service.impl;

import com.example.recept_back.mapper.ReceptMapper;
import com.example.recept_back.model.dto.recept.ReceptRequestDto;
import com.example.recept_back.model.dto.recept.ReceptResponseDto;
import com.example.recept_back.model.entity.Recept;
import com.example.recept_back.repo.ReceptRepo;
import com.example.recept_back.service.abstracts.ReceptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptServiceImpl implements ReceptService {

    private final ReceptRepo receptRepo;
    private final ReceptMapper receptMapper;

    public ReceptServiceImpl(ReceptRepo receptRepo, ReceptMapper receptMapper) {
        this.receptRepo = receptRepo;
        this.receptMapper = receptMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<ReceptResponseDto> getAllRecepts() {
        return receptMapper.toDtoList(receptRepo.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReceptResponseDto> getAllReceptByUserId(Long id) {
        return receptMapper.toDtoList(receptRepo.findAllReceptByUserId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReceptResponseDto> getAllReceptByTagId(Long id) {
        return receptMapper.toDtoList(receptRepo.findAllByReceptTags_Id(id));
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ReceptResponseDto> getReceptById(Long id) {
        return receptRepo.findById(id).map(receptMapper::toDto);
    }


    @Override
    @Transactional
    public ReceptResponseDto saveRecept(ReceptRequestDto dto) {
        Recept entity = receptMapper.fromDto(dto);
        Recept saved = receptRepo.save(entity);
        return receptMapper.toDto(saved);
    }


    @Override
    @Transactional
    public void deleteRecept(Long id) {
        receptRepo.deleteById(id);
    }

}
