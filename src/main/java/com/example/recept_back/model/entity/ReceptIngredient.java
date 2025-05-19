package com.example.recept_back.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recept_ingredient")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "recept")
@EqualsAndHashCode(exclude = "recept")
public class ReceptIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingName;

    private Double ingWeight;

    private Integer ingCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receptId", nullable = false)
    private Recept recept;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public Double getIngWeight() {
        return ingWeight;
    }

    public void setIngWeight(Double ingWeight) {
        this.ingWeight = ingWeight;
    }

    public Integer getIngCount() {
        return ingCount;
    }

    public void setIngCount(Integer ingCount) {
        this.ingCount = ingCount;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }
}
