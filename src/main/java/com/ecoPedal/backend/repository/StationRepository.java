package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByVille(String ville);

    List<Station> findByNomContaining(String nom);
}