package it.hrme.business;

import it.hrme.business.dao.ContractDAO;
import it.hrme.domain.Contract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ContractService {

    private final ContractDAO contractDAO;

    @Transactional
    public Contract save(Contract contract) {
        return contractDAO.save(contract);
    }

    public List<Contract> findAll() {
        return contractDAO.findALl();
    }
}
