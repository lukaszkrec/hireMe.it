package it.hrme.infrastructure.database.repository;

import it.hrme.business.dao.ContractDAO;
import it.hrme.domain.Contract;
import it.hrme.infrastructure.database.entity.ContractEntity;
import it.hrme.infrastructure.database.repository.jpa.ContractJpaRepository;
import it.hrme.infrastructure.database.repository.mapper.ContractEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractRepository implements ContractDAO {

    private final ContractJpaRepository contractJpaRepository;
    private final ContractEntityMapper contractEntityMapper;

    @Override
    public Contract save(Contract contract) {
        ContractEntity contractEntity = contractEntityMapper.mapToEntity(contract);
        ContractEntity savedContract = contractJpaRepository.save(contractEntity);
        return contractEntityMapper.mapFromEntity(savedContract);
    }

    @Override
    public List<Contract> findALl() {
        return contractJpaRepository.findAll()
                .stream()
                .map(contractEntityMapper::mapFromEntity)
                .toList();
    }
}
