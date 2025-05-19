package com.example.recept_back.model.dto.receptIngredient;

import lombok.Data;

@Data
public class ReceptIngredientRequestDto {
    private String ingName;
    private Double ingWeight;
    private Integer ingCount;

}

