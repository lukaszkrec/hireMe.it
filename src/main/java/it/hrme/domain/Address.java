package it.hrme.domain;

import lombok.*;

@With
@Value
@Builder
@ToString(exclude = {"candidate", "company"})
@EqualsAndHashCode(of = "uuid")
public class Address {

    Long id;
    String uuid;
    String country;
    String city;
    String postalCode;
    String street;
    Candidate candidate;
    Company company;
}
