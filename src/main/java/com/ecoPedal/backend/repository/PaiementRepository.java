package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Paiement;
import com.ecoPedal.backend.entity.enums.StatutPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByUtilisateurId(Long userId);
    List<Paiement> findByStatut(StatutPaiement statut);

    // Trouver la caution liée à une réservation
    Optional<Paiement> findByReservationId(Long reservationId);

    boolean existsByReservationId(Long reservationId);

    List<Paiement> findByUtilisateurIdOrderByDatePaiementDesc(Long utilisateurId);

    // Trouver le paiement final lié à une location
    Optional<Paiement> findByLocationId(Long locationId);
}