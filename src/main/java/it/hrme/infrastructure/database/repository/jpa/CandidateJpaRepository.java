package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {

    CandidateEntity findByAvailability_Status(String status);

    @Query("""
            select candidate from CandidateEntity candidate
            join fetch candidate.skills skills
            join fetch candidate.address address
            join fetch candidate.availability availability
            where concat(skills.skillName , address.country , availability.status)  like %?1%
                        """)
    List<CandidateEntity> search(String keyword);
}
