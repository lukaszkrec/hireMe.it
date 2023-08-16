package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "job_offer")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"skills",
        "contract",
        "workTypes",
        "requiredWorkAvailabilities",
        "employmentForms",
        "locations"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "job_offer_id"))
public class JobOfferEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "date_published")
    private LocalDate datePublished;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "job_offer_skill", joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> skills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private AgentEntity agent;

    @OneToOne(mappedBy = "jobOffer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ContractEntity contract;

    @OneToMany(mappedBy = "jobOffer", fetch = FetchType.EAGER)
    private Set<WorkTypeEntity> workTypes;

    @OneToMany(mappedBy = "jobOffer", fetch = FetchType.EAGER)
    private Set<RequiredWorkAvailabilityEntity> requiredWorkAvailabilities;

    @OneToMany(mappedBy = "jobOffer", fetch = FetchType.EAGER)
    private Set<EmploymentFormEntity> employmentForms;

    @OneToMany(mappedBy = "jobOffer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<LocationEntity> locations;

    public void addSkill(SkillEntity skillEntity) {
        this.skills.add(skillEntity);
    }

    public void remove(SkillEntity skillEntity) {
        this.skills.remove(skillEntity);
    }
}
