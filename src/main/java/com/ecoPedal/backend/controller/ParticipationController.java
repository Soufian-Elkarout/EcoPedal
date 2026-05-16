package com.ecoPedal.backend.controller;

import com.ecoPedal.backend.entity.Participation;
import com.ecoPedal.backend.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/participations")
@CrossOrigin(origins = "*")
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @PostMapping("/inscrire")
    public ResponseEntity<Participation> inscrireADefi(
            @RequestParam Long utilisateurId,
            @RequestParam Long defiId) {
        return ResponseEntity.ok(participationService.inscrireADefi(utilisateurId, defiId));
    }

    @PutMapping("/{id}/progression")
    public ResponseEntity<Participation> mettreAJourProgression(
            @PathVariable Long id,
            @RequestParam double nouvelleProgression) {
        return ResponseEntity.ok(participationService.mettreAJourProgression(id, nouvelleProgression));
    }

    @PutMapping("/{id}/completer")
    public ResponseEntity<Participation> completerDefi(@PathVariable Long id) {
        return ResponseEntity.ok(participationService.completerDefi(id));
    }

    @GetMapping("/utilisateur/{userId}")
    public ResponseEntity<List<Participation>> getParticipationsByUtilisateur(@PathVariable Long userId) {
        return ResponseEntity.ok(participationService.getParticipationsByUtilisateur(userId));
    }

    @GetMapping("/defi/{defiId}")
    public ResponseEntity<List<Participation>> getParticipantsByDefi(@PathVariable Long defiId) {
        return ResponseEntity.ok(participationService.getParticipantsByDefi(defiId));
    }
}