package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = "jobOffers")
@EqualsAndHashCode(of = "uuid")
public class Location {

    Long id;
    String uuid;
    String country;
    String city;
    String postalCode;
    String address;
    @Builder.Default
    Set<JobOffer> jobOffers = new HashSet<>();
}
