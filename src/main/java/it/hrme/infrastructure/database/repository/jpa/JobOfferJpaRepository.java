package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface JobOfferJpaRepository extends JpaRepository<JobOfferEntity, Long> {

    @Query("""
            select job from JobOfferEntity job
            join fetch job.skills skills
            join fetch job.locations locations
            join fetch job.workTypes workTypes
            join fetch job.requiredWorkAvailabilities requiredWorkAvailabilities
            join fetch job.employmentForms employmentForms
            where concat(job.title, job.salary, skills.skillName, locations.country, workTypes.type, requiredWorkAvailabilities.workAvailability, employmentForms.form)  like %?1%           
            """)
    List<JobOfferEntity> search(String keyword);
}
