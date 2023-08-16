package it.hrme.domain;

import lombok.*;

import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = {"agents", "address"})
@EqualsAndHashCode(of = "uuid")
public class Company {

    Long id;
    String uuid;
    String companyName;
    String industry;
    String description;
    Set<Agent> agents;
    Address address;
}
