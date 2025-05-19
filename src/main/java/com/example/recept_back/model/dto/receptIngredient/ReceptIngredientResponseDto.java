package com.example.recept_back.model.dto.receptIngredient;

import lombok.Data;

@Data
public class ReceptIngredientResponseDto {
    private Long id;
    private String ingName;
    private Double ingWeight;
    private Integer ingCount;

}

