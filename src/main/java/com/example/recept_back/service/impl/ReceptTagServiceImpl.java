package com.example.recept_back.service.impl;

import com.example.recept_back.model.entity.ReceptTag;
import com.example.recept_back.repo.ReceptTagRepo;
import com.example.recept_back.service.abstracts.ReceptTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptTagServiceImpl implements ReceptTagService {

    private final ReceptTagRepo receptTagRepo;

    public ReceptTagServiceImpl(ReceptTagRepo receptTagRepo) {
        this.receptTagRepo = receptTagRepo;
    }


    @Override
    @Transactional(readOnly = true)
    public List<ReceptTag> getAllReceptTags() {
        return receptTagRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReceptTag> getReceptTagById(Long id) {
        return receptTagRepo.findById(id);
    }

    @Override
    @Transactional
    public ReceptTag saveRecept(ReceptTag receptTag) {
        return receptTagRepo.save(receptTag);
    }

    @Override
    @Transactional
    public void deleteReceptTag(Long id) {
        receptTagRepo.deleteById(id);
    }
}
