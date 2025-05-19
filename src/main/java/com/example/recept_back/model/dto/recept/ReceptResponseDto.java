package com.example.recept_back.model.dto.recept;

import com.example.recept_back.model.dto.receptIngredient.ReceptIngredientResponseDto;
import com.example.recept_back.model.dto.receptTag.ReceptTagResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class ReceptResponseDto {
    private Long id;
    private String receptName;
    private int receptTime;
    private int receptPortions;
    private String receptDescription;
    private String receptImage;
    private String receptLink;
    private Long userId;
    private List<ReceptTagResponseDto> tags;
    private List<ReceptIngredientResponseDto> ingredients;

}
