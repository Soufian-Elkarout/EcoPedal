package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Reservation;
import com.ecoPedal.backend.entity.enums.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUtilisateurId(Long userId);
    List<Reservation> findByVeloId(Long veloId);
    List<Reservation> findByStatut(StatutReservation statut);

    // Pour trouver les réservations ACTIVES dont la date est déjà dépassée
    List<Reservation> findByStatutAndDateExpirationBefore(StatutReservation statut, LocalDateTime now);
}