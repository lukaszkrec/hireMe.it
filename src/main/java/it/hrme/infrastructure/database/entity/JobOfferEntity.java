package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "job_offer")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"skills",
        "agent",
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

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "job_offer_skill",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<SkillEntity> skills = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "agent_id")
    private AgentEntity agent;

    @OneToOne(mappedBy = "jobOffer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ContractEntity contract;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "job_offer_work_type",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "work_type_id")
    )
    private Set<WorkTypeEntity> workTypes = new HashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "job_offer_required_work_availability",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "required_work_availability_id")
    )
    private Set<RequiredWorkAvailabilityEntity> requiredWorkAvailabilities = new HashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "job_offer_employment_form",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "employment_form_id")
    )
    private Set<EmploymentFormEntity> employmentForms = new HashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "job_offer_location",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<LocationEntity> locations = new HashSet<>();
}
