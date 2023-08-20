package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.WorkTypeDAO;
import it.hrme.domain.WorkType;
import it.hrme.infrastructure.database.repository.jpa.WorkTypeJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.WorkTypeEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WorkTypeRepository implements WorkTypeDAO {

    private final WorkTypeJpaRepository workTypeJpaRepository;
    private final WorkTypeEntityMapper workTypeEntityMapper;

    @Override
    public List<WorkType> findAll() {
        return workTypeJpaRepository.findAll()
                .stream()
                .map(workTypeEntityMapper::mapFromEntity)
                .toList();
    }
}
