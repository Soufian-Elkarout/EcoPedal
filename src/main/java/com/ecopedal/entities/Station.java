package com.ecopedal.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "station")

public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;
    private String ville;
    private int capacite;

    @OneToMany(mappedBy = "station")
    private List<Velo> veloList = new ArrayList<>();

    @OneToMany(mappedBy = "station")
    private List<Location> locationList = new ArrayList<>();

    @OneToMany(mappedBy = "station")
    private List<Reservation> reservationList = new ArrayList<>();
}