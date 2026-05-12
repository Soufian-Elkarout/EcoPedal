package com.ecoPedal.backend.services;

import com.ecoPedal.backend.entity.Velo;
import com.ecoPedal.backend.repository.VeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeloService {

    @Autowired
    private VeloRepository veloRepository;

    // Ajouter un vélo
    public Velo creerVelo(Velo velo) {
        return veloRepository.save(velo);
    }

    // Récupérer tous les vélos
    public List<Velo> getTousVelos() {
        return veloRepository.findAll();
    }

    // Récupérer un vélo par ID
    public Optional<Velo> getVeloById(Long id) {
        return veloRepository.findById(id);
    }

    // Modifier un vélo
    public Velo modifierVelo(Long id, Velo nouveauVelo) {

        Velo velo = veloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vélo introuvable"));

        velo.setNumero(nouveauVelo.getNumero());
        velo.setCodeQr(nouveauVelo.getCodeQr());
        velo.setStatut(nouveauVelo.getStatut());
        velo.setStation(nouveauVelo.getStation());

        return veloRepository.save(velo);
    }

    // Supprimer un vélo
    public void supprimerVelo(Long id) {
        veloRepository.deleteById(id);
    }
}
