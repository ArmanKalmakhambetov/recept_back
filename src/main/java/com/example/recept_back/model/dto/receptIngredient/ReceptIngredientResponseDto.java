package com.example.recept_back.model.dto.receptIngredient;

import lombok.Data;

@Data
public class ReceptIngredientResponseDto {
    private Long id;
    private String ingName;
    private Double ingWeight;
    private Integer ingCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

