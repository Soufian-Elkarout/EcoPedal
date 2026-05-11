package com.ecopedal.repositories;


import com.ecopedal.entities.Reservation;
import com.ecopedal.entities.enums.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUtilisateurId(Long userId);
    List<Reservation> findByBikeId(Long bikeId);
    List<Reservation> findByStatut(StatutReservation statut);
}