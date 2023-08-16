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
@Table(name = "agent")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"company", "jobOffers"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "agent_id"))
public class AgentEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @OneToMany(mappedBy = "agent", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<JobOfferEntity> jobOffers;
}
