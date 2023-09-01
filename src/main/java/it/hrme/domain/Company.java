package it.hrme.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(exclude = {"agents"})
@EqualsAndHashCode(of = "uuid")
public class Company {

    Long id;
    String uuid;
    String companyName;
    String industry;
    String description;
    @Builder.Default
    Set<Agent> agents = new HashSet<>();
}
