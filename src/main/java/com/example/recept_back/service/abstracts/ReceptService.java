package com.example.recept_back.service.abstracts;

import com.example.recept_back.model.entity.Recept;

import java.util.List;
import java.util.Optional;

public interface ReceptService {
    List<Recept> getAllRecepts();

    Optional<Recept> getReceptById(Long id);

    Recept saveRecept(Recept recept);

    void deleteRecept(Long id);
}
