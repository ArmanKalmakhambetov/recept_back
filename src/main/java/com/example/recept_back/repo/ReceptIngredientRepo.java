package com.example.recept_back.repo;

import com.example.recept_back.model.entity.ReceptIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptIngredientRepo extends JpaRepository<ReceptIngredient, Long> {
}
