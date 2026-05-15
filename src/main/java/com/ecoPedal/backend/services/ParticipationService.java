package com.ecoPedal.backend.services;

import com.ecoPedal.backend.entity.Participation;
import com.ecoPedal.backend.entity.enums.StatutParticipation;
import com.ecoPedal.backend.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {

    @Autowired
    private ParticipationRepository participationRepository;

    public Participation participer(Participation participation) {
        participation.setDateInscription(LocalDateTime.now());
        participation.setStatut(StatutParticipation.EN_COURS);
        participation.setProgression(0);
        return participationRepository.save(participation);
    }

    public Participation updateProgression(Long id, Integer progression) {
        Participation participation = participationRepository.findById(id).orElseThrow();
        participation.setProgression(progression);
        if (progression >= 100) {
            participation.setStatut(StatutParticipation.COMPLETE);
            participation.setDateCompletion(LocalDateTime.now());
        }
        return participationRepository.save(participation);
    }

    public List<Participation> getToutesParticipations() {
        return participationRepository.findAll();
    }

    public Optional<Participation> getParticipationById(Long id) {
        return participationRepository.findById(id);
    }

    public List<Participation> getParticipationsByUtilisateur(Long userId) {
        return participationRepository.findByUtilisateurId(userId);
    }

    public List<Participation> getParticipationsByDefi(Long defiId) {
        return participationRepository.findByDefiId(defiId);
    }

    public Participation abandonner(Long id) {
        Participation participation = participationRepository.findById(id).orElseThrow();
        participation.setStatut(StatutParticipation.ABANDONNE);
        return participationRepository.save(participation);
    }

    public void supprimerParticipation(Long id) {
        participationRepository.deleteById(id);
    }
}