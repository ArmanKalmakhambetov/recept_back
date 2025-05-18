package com.example.recept_back.service.abstracts;


import com.example.recept_back.model.entity.ReceptTag;

import java.util.List;
import java.util.Optional;

public interface ReceptTagService {
    List<ReceptTag> getAllReceptTags();

    Optional<ReceptTag> getReceptTagById(Long id);

    ReceptTag saveRecept(ReceptTag receptTag);

    void deleteReceptTag(Long id);
}
