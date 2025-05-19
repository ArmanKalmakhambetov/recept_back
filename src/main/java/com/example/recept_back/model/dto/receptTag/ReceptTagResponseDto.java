package com.example.recept_back.model.dto.receptTag;

import lombok.Data;

@Data
public class ReceptTagResponseDto {
    private Long id;
    private String tagName;
    private boolean isGlobal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
