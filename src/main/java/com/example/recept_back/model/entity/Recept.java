package com.example.recept_back.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "recept")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"user", "receptTags"})
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receptName;

    private int receptTime;

    private int receptPortions;

    private String receptDescription;

    private String receptImage;

    private String receptLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private User user;


    @ManyToMany
    @JoinTable(
            name = "recept_tags",
            joinColumns = @JoinColumn(name = "recept_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<ReceptTag> receptTags;

    @OneToMany(mappedBy = "recept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReceptIngredient> ingredients;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recept recept = (Recept) o;
        return receptTime == recept.receptTime && receptPortions == recept.receptPortions && Objects.equals(id, recept.id) && Objects.equals(receptName, recept.receptName) && Objects.equals(receptDescription, recept.receptDescription) && Objects.equals(receptImage, recept.receptImage) && Objects.equals(receptLink, recept.receptLink) && Objects.equals(user, recept.user) && Objects.equals(receptTags, recept.receptTags) && Objects.equals(ingredients, recept.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receptName, receptTime, receptPortions, receptDescription, receptImage, receptLink, user, receptTags, ingredients);
    }
}
