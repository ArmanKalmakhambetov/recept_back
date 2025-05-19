package com.example.recept_back.model.dto.recept;

import com.example.recept_back.model.dto.receptIngredient.ReceptIngredientRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class ReceptRequestDto {
    private String receptName;
    private int receptTime;
    private int receptPortions;
    private String receptDescription;
    private String receptImage;
    private String receptLink;
    private Long userId;
    private List<Long> tagIds;
    private List<ReceptIngredientRequestDto> ingredients;
}
