package com.ecopedal.repositories;

import com.ecopedal.entities.Incident;
import com.ecopedal.entities.enums.StatutIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByStatut(String statut);

    List<Incident> findByBikeId(Long bikeId);

    List<Incident> findByUtilisateurId(Long userId);
}