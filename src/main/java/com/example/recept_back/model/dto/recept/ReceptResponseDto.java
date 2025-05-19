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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceptName() {
        return receptName;
    }

    public void setReceptName(String receptName) {
        this.receptName = receptName;
    }

    public int getReceptTime() {
        return receptTime;
    }

    public void setReceptTime(int receptTime) {
        this.receptTime = receptTime;
    }

    public int getReceptPortions() {
        return receptPortions;
    }

    public void setReceptPortions(int receptPortions) {
        this.receptPortions = receptPortions;
    }

    public String getReceptDescription() {
        return receptDescription;
    }

    public void setReceptDescription(String receptDescription) {
        this.receptDescription = receptDescription;
    }

    public String getReceptImage() {
        return receptImage;
    }

    public void setReceptImage(String receptImage) {
        this.receptImage = receptImage;
    }

    public String getReceptLink() {
        return receptLink;
    }

    public void setReceptLink(String receptLink) {
        this.receptLink = receptLink;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ReceptTagResponseDto> getTags() {
        return tags;
    }

    public void setTags(List<ReceptTagResponseDto> tags) {
        this.tags = tags;
    }

    public List<ReceptIngredientResponseDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<ReceptIngredientResponseDto> ingredients) {
        this.ingredients = ingredients;
    }
}
