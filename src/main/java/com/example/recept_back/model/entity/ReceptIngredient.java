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

}
