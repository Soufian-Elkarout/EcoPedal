package com.ecopedal.repositories;

import com.ecopedal.entities.Velo;
import com.ecopedal.entities.enums.StatutVelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface VeloRepository extends JpaRepository<Velo, Long> {

    List<Velo> findByStationId(Long stationId);

    List<Velo> findByDisponibleTrue();

    List<Velo> findByType(String type);
}