package com.example.recept_back.service.impl;

import com.example.recept_back.model.entity.ReceptIngredient;
import com.example.recept_back.repo.ReceptIngredientRepo;
import com.example.recept_back.service.abstracts.ReceptIngredientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptIngredientServiceImpl implements ReceptIngredientService {

    private final ReceptIngredientRepo receptIngredientRepo;

    public ReceptIngredientServiceImpl(ReceptIngredientRepo receptIngredientRepo) {
        this.receptIngredientRepo = receptIngredientRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReceptIngredient> getAllReceptIngredients() {
        return receptIngredientRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReceptIngredient> getReceptIngredientById(Long id) {
        return receptIngredientRepo.findById(id);
    }

    @Override
    @Transactional
    public ReceptIngredient saveReceptIngredient(ReceptIngredient receptIngredient) {
        return receptIngredientRepo.save(receptIngredient);
    }

    @Override
    @Transactional
    public void deleteReceptIngredient(Long id) {
        receptIngredientRepo.deleteById(id);
    }
}
