package it.hrme.domain;

import lombok.*;

@With
@Value
@Builder
@ToString(exclude = "jobOffer")
@EqualsAndHashCode(of = "uuid")
public class Location {

    Long id;
    String uuid;
    String country;
    String city;
    String postalCode;
    String address;
    JobOffer jobOffer;
}
