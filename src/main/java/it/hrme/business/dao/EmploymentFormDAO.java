package it.hrme.business.dao;

import it.hrme.domain.EmploymentForm;

import java.util.List;

public interface EmploymentFormDAO {
    List<EmploymentForm> findAll();
}
