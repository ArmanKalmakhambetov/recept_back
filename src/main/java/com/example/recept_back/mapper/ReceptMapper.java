package com.example.recept_back.mapper;

import com.example.recept_back.model.dto.recept.*;
import com.example.recept_back.model.dto.receptIngredient.ReceptIngredientRequestDto;
import com.example.recept_back.model.dto.receptIngredient.ReceptIngredientResponseDto;
import com.example.recept_back.model.dto.receptTag.ReceptTagResponseDto;
import com.example.recept_back.model.entity.Recept;
import com.example.recept_back.model.entity.ReceptIngredient;
import com.example.recept_back.model.entity.ReceptTag;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceptMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "receptTags", target = "tags")
    @Mapping(source = "ingredients", target = "ingredients")
    ReceptResponseDto toDto(Recept recept);

    List<ReceptResponseDto> toDtoList(List<Recept> recepts);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "receptTags", ignore = true) // manually set later from tagIds
    @Mapping(target = "ingredients", ignore = true) // manually map ingredients
    Recept fromDto(ReceptRequestDto dto);

    ReceptIngredientResponseDto toDto(ReceptIngredient ingredient);

    List<ReceptIngredientResponseDto> toDtoIngList(List<ReceptIngredient> ingredients);

    ReceptIngredient fromDto(ReceptIngredientRequestDto dto);

    List<ReceptIngredient> fromDtoIngList(List<ReceptIngredientRequestDto> dtos);

    ReceptTagResponseDto toDto(ReceptTag tag);

    List<ReceptTagResponseDto> toDtoTagList(List<ReceptTag> tags);
}