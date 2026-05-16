package com.ecoPedal.backend.controller;

import com.ecoPedal.backend.entity.PointHistorique;
import com.ecoPedal.backend.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/points")
@CrossOrigin(origins = "*")
public class PointHistoriqueController {

    @Autowired
    private PointService pointService;

    @GetMapping("/solde/{utilisateurId}")
    public ResponseEntity<Integer> getSoldePoints(@PathVariable Long utilisateurId) {
        return ResponseEntity.ok(pointService.getSoldePoints(utilisateurId));
    }

    @PostMapping("/ajouter")
    public ResponseEntity<PointHistorique> ajouterPoints(
            @RequestParam Long utilisateurId,
            @RequestParam int points,
            @RequestParam String description) {
        return ResponseEntity.ok(pointService.ajouterPoints(utilisateurId, points, description));
    }

    @PostMapping("/deduire")
    public ResponseEntity<PointHistorique> deduirePoints(
            @RequestParam Long utilisateurId,
            @RequestParam int points,
            @RequestParam String description) {
        return ResponseEntity.ok(pointService.deduirePoints(utilisateurId, points, description));
    }

    @GetMapping("/verifier/{utilisateurId}")
    public ResponseEntity<Boolean> aAssezDePoints(
            @PathVariable Long utilisateurId,
            @RequestParam int pointsRequis) {
        return ResponseEntity.ok(pointService.aAssezDePoints(utilisateurId, pointsRequis));
    }
}