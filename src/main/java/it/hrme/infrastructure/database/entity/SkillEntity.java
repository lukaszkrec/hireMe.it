package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "skill")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"candidates", "jobOffers"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "skill_id"))
public class SkillEntity extends BaseEntity {

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(mappedBy = "skills")
    private Set<CandidateEntity> candidates;

    @ManyToMany(mappedBy = "skills")
    private Set<JobOfferEntity> jobOffers;
}
