package com.ecoPedal.backend.service;

import com.ecoPedal.backend.entity.Utilisateur;
import com.ecoPedal.backend.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getTousUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Optional<Utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur modifierUtilisateur(Long id, Utilisateur updated) {
        updated.setId(id);
        return utilisateurRepository.save(updated);
    }

    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur ajouterPoints(Long id, Integer points) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow();
        utilisateur.setSoldePoints(utilisateur.getSoldePoints() + points);
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur deduirePoints(Long id, Integer points) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow();
        utilisateur.setSoldePoints(utilisateur.getSoldePoints() - points);
        return utilisateurRepository.save(utilisateur);
    }
}