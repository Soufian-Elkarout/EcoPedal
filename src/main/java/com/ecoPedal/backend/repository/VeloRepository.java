package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Velo;
import com.ecoPedal.backend.entity.enums.StatutVelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface VeloRepository extends JpaRepository<Velo, Long> {

    // Tous les vélos d'une station
    List<Velo> findByStationId(Long stationId);

    // Vélos filtrés par statut (DISPONIBLE, RESERVE, EN_LOCATION)
    List<Velo> findByStatut(StatutVelo statut);

    // Vélos disponibles dans une station précise
    List<Velo> findByStationIdAndStatut(Long stationId, StatutVelo statut);

    // Trouver un vélo par son numéro physique (collé sur le vélo)
    Optional<Velo> findByNumero(int numero);

    // Trouver un vélo par son code QR
    Optional<Velo> findByCodeQr(String codeQr);
}