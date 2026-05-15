package com.ecoPedal.backend.services;

import com.ecoPedal.backend.entity.Recompense;
import com.ecoPedal.backend.repository.RecompenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecompenseService {

    @Autowired
    private RecompenseRepository recompenseRepository;

    public Recompense creerRecompense(Recompense recompense) {
        return recompenseRepository.save(recompense);
    }

    public List<Recompense> getToutesRecompenses() {
        return recompenseRepository.findAll();
    }

    public Optional<Recompense> getRecompenseById(Long id) {
        return recompenseRepository.findById(id);
    }

    public List<Recompense> getRecompensesDisponibles(Integer pointsUtilisateur) {
        return recompenseRepository.findByCoutPointsLessThanEqual(pointsUtilisateur);
    }

    public Recompense modifierRecompense(Long id, Recompense updated) {
        updated.setId(id);
        return recompenseRepository.save(updated);
    }

    public void supprimerRecompense(Long id) {
        recompenseRepository.deleteById(id);
    }
}