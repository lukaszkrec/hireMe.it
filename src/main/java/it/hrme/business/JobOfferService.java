package it.hrme.business;

import it.hrme.business.dao.JobOfferDAO;
import it.hrme.domain.JobOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobOfferService {

    private final JobOfferDAO jobOfferDAO;

    @Transactional
    public JobOffer save(JobOffer jobOffer) {
        return jobOfferDAO.save(jobOffer);
    }

    @Transactional
    public List<JobOffer> findAll() {
        return jobOfferDAO.findAll();
    }

    @Transactional
    public JobOffer findById(Long jobOfferId) {
        return jobOfferDAO.findById(jobOfferId);
    }

    @Transactional
    public List<JobOffer> findAllByWorkType(String workType) {
        return jobOfferDAO.findAllByWorkType(workType);
    }

    @Transactional
    public List<JobOffer> findAllBySkill(String skill) {
        return jobOfferDAO.findAllBySkill(skill);
    }

    @Transactional
    public List<JobOffer> findAllByRequiredWorkAvailability(String workAvailability) {
        return jobOfferDAO.findAllByRequiredWorkAvailability(workAvailability);
    }

    @Transactional
    public List<JobOffer> findAllByEmploymentForm(String employmentForm) {
        return jobOfferDAO.findAllByEmploymentForm(employmentForm);
    }

    @Transactional
    public List<JobOffer> findAllByCountry(String country) {
        return jobOfferDAO.findAllByCountry(country);
    }
}


