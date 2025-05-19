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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceptName() {
        return receptName;
    }

    public void setReceptName(String receptName) {
        this.receptName = receptName;
    }

    public int getReceptTime() {
        return receptTime;
    }

    public void setReceptTime(int receptTime) {
        this.receptTime = receptTime;
    }

    public int getReceptPortions() {
        return receptPortions;
    }

    public void setReceptPortions(int receptPortions) {
        this.receptPortions = receptPortions;
    }

    public String getReceptDescription() {
        return receptDescription;
    }

    public void setReceptDescription(String receptDescription) {
        this.receptDescription = receptDescription;
    }

    public String getReceptImage() {
        return receptImage;
    }

    public void setReceptImage(String receptImage) {
        this.receptImage = receptImage;
    }

    public String getReceptLink() {
        return receptLink;
    }

    public void setReceptLink(String receptLink) {
        this.receptLink = receptLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ReceptTag> getReceptTags() {
        return receptTags;
    }

    public void setReceptTags(List<ReceptTag> receptTags) {
        this.receptTags = receptTags;
    }

    public List<ReceptIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<ReceptIngredient> ingredients) {
        this.ingredients = ingredients;
    }

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
