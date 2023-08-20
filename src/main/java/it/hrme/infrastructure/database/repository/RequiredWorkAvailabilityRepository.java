package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.RequiredWorkAvailabilityDAO;
import it.hrme.domain.RequiredWorkAvailability;
import it.hrme.infrastructure.database.repository.jpa.RequiredWorkAvailabilityJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.RequiredWorkAvailabilityEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequiredWorkAvailabilityRepository implements RequiredWorkAvailabilityDAO {

    private final RequiredWorkAvailabilityJpaRepository requiredWorkAvailabilityJpaRepository;
    private final RequiredWorkAvailabilityEntityMapper requiredWorkAvailabilityEntityMapper;

    @Override
    public List<RequiredWorkAvailability> findALl() {
        return requiredWorkAvailabilityJpaRepository.findAll()
                .stream()
                .map(requiredWorkAvailabilityEntityMapper::mapFromEntity)
                .toList();
    }
}
