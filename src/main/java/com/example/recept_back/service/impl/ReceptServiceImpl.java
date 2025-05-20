package com.example.recept_back.service.impl;

import com.example.recept_back.mapper.ReceptMapper;
import com.example.recept_back.model.dto.recept.ReceptRequestDto;
import com.example.recept_back.model.dto.recept.ReceptResponseDto;
import com.example.recept_back.model.entity.Recept;
import com.example.recept_back.model.entity.ReceptIngredient;
import com.example.recept_back.model.entity.ReceptTag;
import com.example.recept_back.model.entity.User;
import com.example.recept_back.repo.ReceptIngredientRepo;
import com.example.recept_back.repo.ReceptRepo;
import com.example.recept_back.repo.ReceptTagRepo;
import com.example.recept_back.repo.UserRepo;
import com.example.recept_back.service.abstracts.ReceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptServiceImpl implements ReceptService {

    private final ReceptRepo receptRepo;
    private final ReceptMapper receptMapper;

    private final UserRepo userRepo;
    private final ReceptTagRepo receptTagRepo;
    private final ReceptIngredientRepo receptIngredientRepo;


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

    @Override
    @Transactional
    public ReceptResponseDto createRecept(ReceptRequestDto dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<ReceptTag> tags = receptTagRepo.findAllById(dto.getTagIds());

        Recept recept = new Recept();
        recept.setReceptName(dto.getReceptName());
        recept.setReceptTime(dto.getReceptTime());
        recept.setReceptPortions(dto.getReceptPortions());
        recept.setReceptDescription(dto.getReceptDescription());
        recept.setReceptImage(dto.getReceptImage());
        recept.setReceptLink(dto.getReceptLink());
        recept.setUser(user);
        recept.setReceptTags(tags);

        // Пока не сохраняем, сначала добавим ингредиенты
        List<ReceptIngredient> ingredients = dto.getIngredients().stream()
                .map(ingredientDto -> {
                    ReceptIngredient ingredient = new ReceptIngredient();
                    ingredient.setIngName(ingredientDto.getIngName());
                    ingredient.setIngWeight(ingredientDto.getIngWeight());
                    ingredient.setIngCount(ingredientDto.getIngCount());
                    ingredient.setRecept(recept); // связка!
                    return ingredient;
                })
                .toList();

        recept.setIngredients(ingredients);

        // Сохраняем рецепт и каскадно — ингредиенты
        // cascade сохраняет ингредиенты
        Recept saved =  receptRepo.save(recept);
        return receptMapper.toDto(saved);
    }

}
