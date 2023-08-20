package it.hrme.domain;

import lombok.*;

import java.time.LocalDate;

@With
@Value
@Builder
@ToString(exclude = {"candidate", "jobOffer"})
@EqualsAndHashCode(of = "uuid")
public class Contract {

    Long id;
    String uuid;
    LocalDate startDate;
    LocalDate endDate;
    Candidate candidate;
    JobOffer jobOffer;




}
