package com.example.recept_back.model.dto.receptTag;

import lombok.Data;

@Data
public class ReceptTagRequestDto {
    private String tagName;
    private boolean isGlobal;
    private Long userId;
}

