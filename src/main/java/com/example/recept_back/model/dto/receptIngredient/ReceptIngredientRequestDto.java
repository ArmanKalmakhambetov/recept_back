package com.example.recept_back.model.dto.receptIngredient;

import lombok.Data;

@Data
public class ReceptIngredientRequestDto {
    private String ingName;
    private Double ingWeight;
    private Integer ingCount;

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public Double getIngWeight() {
        return ingWeight;
    }

    public void setIngWeight(Double ingWeight) {
        this.ingWeight = ingWeight;
    }

    public Integer getIngCount() {
        return ingCount;
    }

    public void setIngCount(Integer ingCount) {
        this.ingCount = ingCount;
    }
}

