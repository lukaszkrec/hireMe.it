package it.hrme.business.dao;

import it.hrme.domain.JobOffer;

import java.util.List;
import java.util.Set;

public interface JobOfferDAO {

    Set<JobOffer> findAll();

    JobOffer findById(Long jobOfferId);

    List<JobOffer> search(String keyword);
}
