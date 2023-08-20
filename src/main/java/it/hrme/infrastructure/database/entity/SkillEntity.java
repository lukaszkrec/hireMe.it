package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
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

    @Builder.Default
    @ManyToMany(mappedBy = "skills")
    private Set<CandidateEntity> candidates = new HashSet<>();

    @Builder.Default
    @ManyToMany(mappedBy = "skills")
    private Set<JobOfferEntity> jobOffers = new HashSet<>();
}
