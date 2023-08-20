package it.hrme.business.dao;

import it.hrme.domain.Contract;

import java.util.List;

public interface ContractDAO {
    Contract save(Contract contract);

    List<Contract> findALl();
}
