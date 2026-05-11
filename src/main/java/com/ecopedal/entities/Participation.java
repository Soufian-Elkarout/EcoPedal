package com.ecopedal.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "participation")

public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateParticipation;
    private int pointsGagnes;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne()
    private Defi defi;
}