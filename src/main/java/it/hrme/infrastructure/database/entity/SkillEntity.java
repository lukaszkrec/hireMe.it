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

    @OneToMany(mappedBy = "skillEntity")
    private Set<CertificationEntity> certifications;

    @OneToMany(mappedBy = "skillEntity")
    private Set<LanguageEntity> languages;

    @OneToMany(mappedBy = "skillEntity")
    private Set<TechnologyEntity> technologies;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_level_id")
    private ExperienceLevelEntity experienceLevelEntity;

    @OneToOne(mappedBy = "skillEntity", fetch = FetchType.LAZY)
    private JobOfferEntity jobOfferEntity;

    @OneToOne(mappedBy = "skillEntity", fetch = FetchType.LAZY)
    private CandidateEntity candidateEntity;
}
