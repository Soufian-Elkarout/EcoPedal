package com.ecopedal.repositories;

import com.ecopedal.entities.Station;
import com.ecopedal.entities.enums.StatutStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByVille(String ville);

    List<Station> findByNomContaining(String nom);
}