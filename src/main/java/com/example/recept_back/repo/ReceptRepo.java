package com.example.recept_back.repo;

import com.example.recept_back.model.entity.Recept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptRepo extends JpaRepository<Recept,Long> {
    List<Recept> findAllReceptByUserId(Long user_id);

    List<Recept> findAllByReceptTags_Id(Long receptTags_id);

}
