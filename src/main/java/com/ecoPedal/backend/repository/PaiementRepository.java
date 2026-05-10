package com.ecoPedal.backend.repository;

import com.ecoPedal.backend.entity.Paiement;
import com.ecoPedal.backend.entity.enums.StatutPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    List<Paiement> findByUtilisateurId(Long userId);
    List<Paiement> findByStatut(StatutPaiement statut);
}