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

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public List<ReceptIngredientRequestDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<ReceptIngredientRequestDto> ingredients) {
        this.ingredients = ingredients;
    }
}
