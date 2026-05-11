package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByStatut(String statut);

    List<Incident> findByVeloId(Long veloId);

    List<Incident> findByUtilisateurId(Long userId);
}