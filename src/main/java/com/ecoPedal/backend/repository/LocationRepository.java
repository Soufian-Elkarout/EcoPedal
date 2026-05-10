package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Location;
import com.ecoPedal.backend.entity.enums.StatutLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByUtilisateurId(Long userId);
    List<Location> findByVeloId(Long veloId);
    List<Location> findByStatut(StatutLocation statut);
}