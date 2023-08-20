package it.hrme.business;

import it.hrme.business.dao.WorkTypeDAO;
import it.hrme.domain.WorkType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class WorkTypeService {

    private final WorkTypeDAO workTypeDAO;

    @Transactional
    public List<WorkType> findALl() {
        return workTypeDAO.findAll();
    }
}
