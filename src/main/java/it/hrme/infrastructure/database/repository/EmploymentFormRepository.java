package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.EmploymentFormDAO;
import it.hrme.domain.EmploymentForm;
import it.hrme.infrastructure.database.repository.jpa.EmploymentFormJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.EmploymentFormEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmploymentFormRepository implements EmploymentFormDAO {

    private final EmploymentFormJpaRepository employmentFormJpaRepository;
    private final EmploymentFormEntityMapper employmentFormEntityMapper;

    @Override
    public List<EmploymentForm> findAll() {
        return employmentFormJpaRepository.findAll()
                .stream()
                .map(employmentFormEntityMapper::mapFromEntity)
                .toList();
    }
}
