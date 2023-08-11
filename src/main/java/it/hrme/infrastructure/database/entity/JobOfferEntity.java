package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_offer")
@AttributeOverride(name = "id", column = @Column(name = "job_offer_id"))
public class JobOfferEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "date_published")
    private Date datePublished;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "skill_id")
    private SkillEntity skillEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private AgentEntity agentEntity;

    @OneToOne(mappedBy = "jobOfferEntity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ContractEntity contractEntity;

    @OneToMany(mappedBy = "jobOfferEntity", fetch = FetchType.EAGER)
    private Set<WorkTypeEntity> workTypeEntities;

    @OneToMany(mappedBy = "jobOfferEntity", fetch = FetchType.EAGER)
    private Set<RequiredWorkAvailability> workTimesEntities;

    @OneToMany(mappedBy = "jobOfferEntity", fetch = FetchType.EAGER)
    private Set<EmploymentFormEntity> employmentFormEntities;

    @OneToMany(mappedBy = "jobOfferEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<LocationEntity> locationEntities;
}
