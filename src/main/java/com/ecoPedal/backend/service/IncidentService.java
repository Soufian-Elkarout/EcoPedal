package com.ecoPedal.backend.service;

import com.ecoPedal.backend.entity.Incident;
import com.ecoPedal.backend.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    // Ajouter un incident
    public Incident creerIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    // Récupérer tous les incidents
    public List<Incident> getTousIncidents() {
        return incidentRepository.findAll();
    }

    // Récupérer un incident par ID
    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    // Modifier un incident
    public Incident modifierIncident(Long id, Incident nouvelIncident) {

        Incident incident = incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident introuvable"));

        incident.setUtilisateur(nouvelIncident.getUtilisateur());
        incident.setLocation(nouvelIncident.getLocation());
        incident.setAdministrateur(nouvelIncident.getAdministrateur());
        incident.setStatut(nouvelIncident.getStatut());

        return incidentRepository.save(incident);
    }

    // Supprimer un incident
    public void supprimerIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}