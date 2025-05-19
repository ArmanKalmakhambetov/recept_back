package com.example.recept_back.model.dto.receptTag;

import lombok.Data;

@Data
public class ReceptTagResponseDto {
    private Long id;
    private String tagName;
    private boolean isGlobal;

}
