package com.example.recept_back.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"user", "recepts"})
public class ReceptTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;

    private boolean isGlobal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private User user;


    @ManyToMany(mappedBy = "receptTags")
    private List<Recept> recepts;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceptTag receptTag = (ReceptTag) o;
        return isGlobal == receptTag.isGlobal && Objects.equals(id, receptTag.id) && Objects.equals(tagName, receptTag.tagName) && Objects.equals(user, receptTag.user) && Objects.equals(recepts, receptTag.recepts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, isGlobal, user, recepts);
    }
}

