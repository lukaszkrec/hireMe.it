package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {

    List<CandidateEntity> findByStatus(CandidateEntity.Status status);

    @Query("""
            SELECT can FROM CandidateEntity can
            JOIN FETCH can.skills skills
            WHERE lower(skills.skillName) = lower(:skill)
            """)
    List<CandidateEntity> findAllBySkill(String skill);


    @Query("""
            SELECT can FROM CandidateEntity can
            JOIN FETCH can.address add
            WHERE lower(add.country) = lower(:country)
            """)
    List<CandidateEntity> findAllByCountry(String country);
}
