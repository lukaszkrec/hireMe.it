package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill")
@AttributeOverride(name = "id", column = @Column(name = "skill_id"))
public class SkillEntity extends BaseEntity {

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(mappedBy = "skillEntities")
    private Set<CandidateEntity> candidateEntities;

    @ManyToMany(mappedBy = "skillEntities")
    private Set<JobOfferEntity> jobOfferEntities;
}
