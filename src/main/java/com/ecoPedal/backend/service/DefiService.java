package com.ecoPedal.backend.service;

import com.ecoPedal.backend.entity.Defi;
import com.ecoPedal.backend.repository.DefiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefiService {

    @Autowired
    private DefiRepository defiRepository;

    // Ajouter un défi
    public Defi creerDefi(Defi defi) {
        return defiRepository.save(defi);
    }

    // Récupérer tous les défis
    public List<Defi> getTousDefis() {
        return defiRepository.findAll();
    }

    // Récupérer un défi par ID
    public Optional<Defi> getDefiById(Long id) {
        return defiRepository.findById(id);
    }

    // Modifier un défi
    public Defi modifierDefi(Long id, Defi nouveauDefi) {

        Defi defi = defiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Défi introuvable"));

        defi.setTitre(nouveauDefi.getTitre());
        defi.setDescription(nouveauDefi.getDescription());
        defi.setPointsRecompense(nouveauDefi.getPointsRecompense());
        defi.setDateDebut(nouveauDefi.getDateDebut());
        defi.setDateFin(nouveauDefi.getDateFin());
        defi.setObjective(nouveauDefi.getObjective());
        defi.setStatut(nouveauDefi.getStatut());
        defi.setAdministrateur(nouveauDefi.getAdministrateur());

        return defiRepository.save(defi);
    }

    // Supprimer un défi
    public void supprimerDefi(Long id) {
        defiRepository.deleteById(id);
    }
}