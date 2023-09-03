package it.hrme.domain;

import it.hrme.infrastructure.database.constants.SkillName;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString
@EqualsAndHashCode(of = "uuid")
public class Skill {

    Long id;
    String uuid;
    SkillName skillName;
}
