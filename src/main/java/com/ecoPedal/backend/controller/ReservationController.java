package com.ecoPedal.backend.controller;

import com.ecoPedal.backend.entity.Reservation;
import com.ecoPedal.backend.entity.enums.MethodePaiement;
import com.ecoPedal.backend.entity.enums.TypeDuree;
import com.ecoPedal.backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> creerReservation(
            @RequestParam Long utilisateurId,
            @RequestParam Long veloId,
            @RequestParam int duree,
            @RequestParam TypeDuree typeDuree,
            @RequestParam MethodePaiement methodePaiement) {
        return ResponseEntity.ok(reservationService.creerReservation(
                utilisateurId, veloId, duree, typeDuree, methodePaiement));
    }

    @PutMapping("/{id}/annuler")
    public ResponseEntity<Reservation> annulerReservation(
            @PathVariable Long id,
            @RequestParam Long utilisateurId) {
        return ResponseEntity.ok(reservationService.annulerReservation(id, utilisateurId));
    }

    @GetMapping("/utilisateur/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUtilisateur(@PathVariable Long userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUtilisateur(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }
}