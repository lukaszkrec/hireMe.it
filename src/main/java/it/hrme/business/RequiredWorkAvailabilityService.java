package it.hrme.business;

import it.hrme.business.dao.RequiredWorkAvailabilityDAO;
import it.hrme.domain.RequiredWorkAvailability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class RequiredWorkAvailabilityService {

    private final RequiredWorkAvailabilityDAO requiredWorkAvailabilityDAO;

    @Transactional
    public List<RequiredWorkAvailability> findAll() {
        return requiredWorkAvailabilityDAO.findALl();
    }
}
