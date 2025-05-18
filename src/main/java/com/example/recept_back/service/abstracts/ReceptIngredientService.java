package com.example.recept_back.service.abstracts;

import com.example.recept_back.model.entity.ReceptIngredient;

import java.util.List;
import java.util.Optional;

public interface ReceptIngredientService {
    List<ReceptIngredient> getAllReceptIngredients();

    Optional<ReceptIngredient> getReceptIngredientById(Long id);

    ReceptIngredient saveReceptIngredient(ReceptIngredient receptIngredient);

    void deleteReceptIngredient(Long id);
}
