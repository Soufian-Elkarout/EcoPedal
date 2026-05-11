package com.ecopedal.entities;
import jakarta.persistence.*;
import lombok.*;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "velo")

public class Velo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean disponible;
    private int numero;

    @ManyToOne
    private Station station;

    @OneToMany(mappedBy = "velo")
    private List<Reservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "velo")
    private List<Location> locationList = new ArrayList<>();

    @OneToMany(mappedBy = "velo")
    private List<Station> stationList = new ArrayList<>();
}