package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.JobOfferDAO;
import it.hrme.domain.JobOffer;
import it.hrme.infrastructure.database.entity.JobOfferEntity;
import it.hrme.infrastructure.database.repository.jpa.JobOfferJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.JobOfferEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobOfferRepository implements JobOfferDAO {

    private final JobOfferJpaRepository jobOfferJpaRepository;
    private final JobOfferEntityMapper offerEntityMapper;

    @Override
    public JobOffer save(JobOffer jobOffer) {
        JobOfferEntity jobOfferEntity = offerEntityMapper.mapToEntity(jobOffer);
        JobOfferEntity savedJobOffer = jobOfferJpaRepository.save(jobOfferEntity);
        return offerEntityMapper.mapFromEntity(savedJobOffer);
    }

    @Override
    public List<JobOffer> findAll() {
        return jobOfferJpaRepository.findAll()
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public JobOffer findById(Long jobOfferId) {
        JobOfferEntity jobOfferEntity = jobOfferJpaRepository.findById(jobOfferId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Job Offer with id: {%s} does not exist".formatted(jobOfferId))
                );
        return offerEntityMapper.mapFromEntity(jobOfferEntity);
    }


    public List<JobOffer> findAllByWorkType(String workType) {
        if (StringUtils.hasText(workType)) {
            return jobOfferJpaRepository.findAllByWorkType(workType)
                    .stream()
                    .map(offerEntityMapper::mapFromEntity)
                    .toList();
        }
        throw new RuntimeException("Unknown work type [%s]".formatted(workType));
    }

    @Override
    public List<JobOffer> findAllBySkill(String skill) {
        return jobOfferJpaRepository.findAllBySkill(skill)
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public List<JobOffer> findAllByRequiredWorkAvailability(String workAvailability) {
        return jobOfferJpaRepository.findAllByRequiredWorkAvailability(workAvailability)
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public List<JobOffer> findAllByEmploymentForm(String employmentForm) {
        return jobOfferJpaRepository.findAllByEmploymentForm(employmentForm)
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .toList();
    }

    @Override
    public List<JobOffer> findAllByCountry(String country) {
        return jobOfferJpaRepository.findAllByCountry(country)
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .toList();
    }
}
