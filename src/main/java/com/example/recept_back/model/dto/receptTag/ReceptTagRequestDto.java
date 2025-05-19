package com.example.recept_back.model.dto.receptTag;

import lombok.Data;

@Data
public class ReceptTagRequestDto {
    private String tagName;
    private boolean isGlobal;
    private Long userId;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean global) {
        isGlobal = global;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

