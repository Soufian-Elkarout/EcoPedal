package com.ecopedal.repositories;
import com.ecopedal.entities.Participation;
import com.ecopedal.entities.enums.StatutParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    List<Participation> findByUtilisateurId(Long userId);

    List<Participation> findByEventId(Long eventId);
}