package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.constants.Status;
import it.hrme.infrastructure.database.entity.CandidateEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {


    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"skills", "contracts"})
    @Override
    List<CandidateEntity> findAll();

    Optional<CandidateEntity> findByEmail(String email);

    List<CandidateEntity> findByStatus(Status status);

    @Query("""
            SELECT can FROM CandidateEntity can
            JOIN FETCH can.skills skills
            WHERE lower(skills.skillName) = lower(:skill)
            """)
    List<CandidateEntity> findAllBySkill(String skill);
}
