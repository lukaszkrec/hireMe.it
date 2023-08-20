package it.hrme.business.dao;

import it.hrme.domain.JobOffer;

import java.util.List;

public interface JobOfferDAO {

    JobOffer save(JobOffer jobOffer);

    List<JobOffer> findAll();

    JobOffer findById(Long jobOfferId);

    List<JobOffer> findAllByWorkType(String workType);

    List<JobOffer> findAllBySkill(String skill);

    List<JobOffer> findAllByRequiredWorkAvailability(String workAvailability);

    List<JobOffer> findAllByEmploymentForm(String employmentForm);

    List<JobOffer> findAllByCountry(String country);
}
