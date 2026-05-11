package com.ecopedal.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "incident")

public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String statut;
    private LocalDateTime date;
    private String localisation;

    @ManyToOne
    @JoinColumn(name="id_utilisateur" ,nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="id_velo" ,nullable = false)
    private Velo velo;

    @ManyToOne
    @JoinColumn(name="id_location" ,nullable = false)
    private Location location;


}