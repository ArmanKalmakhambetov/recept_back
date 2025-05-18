package com.example.recept_back.service.impl;

import com.example.recept_back.model.entity.Recept;
import com.example.recept_back.repo.ReceptRepo;
import com.example.recept_back.service.abstracts.ReceptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptServiceImpl implements ReceptService {

    private final ReceptRepo receptRepo;

    public ReceptServiceImpl(ReceptRepo receptRepo) {
        this.receptRepo = receptRepo;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Recept> getAllRecepts() {
        return receptRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Recept> getReceptById(Long id) {
        return receptRepo.findById(id);
    }

    @Override
    @Transactional
    public Recept saveRecept(Recept recept) {
        return receptRepo.save(recept);
    }

    @Override
    @Transactional
    public void deleteRecept(Long id) {
        receptRepo.deleteById(id);
    }

}
