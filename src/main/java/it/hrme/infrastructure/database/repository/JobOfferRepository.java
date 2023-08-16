package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.JobOfferDAO;
import it.hrme.domain.JobOffer;
import it.hrme.infrastructure.database.entity.JobOfferEntity;
import it.hrme.infrastructure.database.repository.jpa.JobOfferJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.JobOfferEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class JobOfferRepository implements JobOfferDAO {

    private final JobOfferJpaRepository jobOfferJpaRepository;
    private final JobOfferEntityMapper offerEntityMapper;

    @Override
    public Set<JobOffer> findAll() {
        return jobOfferJpaRepository.findAll()
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public JobOffer findById(Long jobOfferId) {
        JobOfferEntity jobOfferEntity = jobOfferJpaRepository.findById(jobOfferId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Job Offer with id: {%s} does not exist".formatted(jobOfferId))
                );
        return offerEntityMapper.mapFromEntity(jobOfferEntity);
    }

    @Override
    public List<JobOffer> search(String keyword) {
        return jobOfferJpaRepository.search(keyword)
                .stream()
                .map(offerEntityMapper::mapFromEntity)
                .toList();
    }
}
