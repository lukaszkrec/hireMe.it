package it.hrme.infrastructure.database.repository.jpa;

import it.hrme.infrastructure.database.entity.JobOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferJpaRepository extends JpaRepository<JobOfferEntity, Long> {

    @Query("""
            SELECT job FROM JobOfferEntity job
            JOIN FETCH job.skills s
            WHERE lower(s.skillName) = lower(:skill)
            """)
    List<JobOfferEntity> findAllBySkill(String skill);

    @Query("""
            SELECT job FROM JobOfferEntity job
            JOIN FETCH job.workTypes wt
            WHERE lower(wt.type) = lower(:workType)
            """)
    List<JobOfferEntity> findAllByWorkType(String workType);

    @Query("""
            SELECT job FROM JobOfferEntity job
            JOIN  FETCH  job.requiredWorkAvailabilities rwa
            WHERE lower(rwa.workAvailability) = lower(:workAvailability)
            """)
    List<JobOfferEntity> findAllByRequiredWorkAvailability(String workAvailability);

    @Query("""
            SELECT job FROM JobOfferEntity job
            JOIN FETCH job.employmentForms ef
            WHERE lower(ef.form) = lower(:employmentForm)
            """)
    List<JobOfferEntity> findAllByEmploymentForm(String employmentForm);

    @Query("""
            SELECT job FROM JobOfferEntity job
            JOIN FETCH job.locations l
            WHERE lower(l.country) = lower(:country)
            """)
    List<JobOfferEntity> findAllByCountry(String country);
}
