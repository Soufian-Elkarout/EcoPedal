package com.ecopedal.entities;

import com.ecopedal.entities.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateReservation;

    @Column(nullable = false)
    private LocalDateTime dateExpiration;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut ;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_velo", nullable = false)
    private Velo velo;

    @OneToOne
    @JoinColumn(name = "id_paiement", nullable = false)
    private Paiement paiement;

    @ManyToOne
    @JoinColumn(name = "id_station", nullable = false)
    private Station station;
}