package it.hrme.business;

import it.hrme.business.dao.EmploymentFormDAO;
import it.hrme.domain.EmploymentForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmploymentFormService {

    private final EmploymentFormDAO employmentFormDAO;

    @Transactional
    public List<EmploymentForm> findALl() {
        return employmentFormDAO.findAll();
    }
}
