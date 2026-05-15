package com.ecoPedal.backend.service;

import com.ecoPedal.backend.entity.Station;
import com.ecoPedal.backend.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    // Ajouter une station
    public Station creerStation(Station station) {
        return stationRepository.save(station);
    }

    // Récupérer toutes les stations
    public List<Station> getToutesStations() {
        return stationRepository.findAll();
    }

    // Récupérer une station par ID
    public Optional<Station> getStationById(Long id) {
        return stationRepository.findById(id);
    }

    // Modifier une station
    public Station modifierStation(Long id, Station nouvelleStation) {

        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station introuvable"));

        station.setNom(nouvelleStation.getNom());
        station.setAdresse(nouvelleStation.getAdresse());
        station.setCapacite(nouvelleStation.getCapacite());

        return stationRepository.save(station);
    }

    // Supprimer une station
    public void supprimerStation(Long id) {
        stationRepository.deleteById(id);
    }
}