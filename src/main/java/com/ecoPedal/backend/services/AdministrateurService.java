package com.ecoPedal.backend.services;

import com.ecoPedal.backend.entity.Administrateur;
import com.ecoPedal.backend.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public Administrateur creerAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public List<Administrateur> getTousAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Optional<Administrateur> getAdministrateurById(Long id) {
        return administrateurRepository.findById(id);
    }

    public Optional<Administrateur> getAdministrateurByEmail(String email) {
        return administrateurRepository.findByEmail(email);
    }

    public Administrateur modifierAdministrateur(Long id, Administrateur updated) {
        updated.setId(id);
        return administrateurRepository.save(updated);
    }

    public void supprimerAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }
}