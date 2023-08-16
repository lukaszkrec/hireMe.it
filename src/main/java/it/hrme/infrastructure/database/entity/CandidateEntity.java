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
@Table(name = "candidate")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"skills", "availability", "address", "contracts"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "candidate_id"))
public class CandidateEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "overview")
    private String overview;

    @Column(name = "work_interest")
    private boolean workInterest;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "candidate_skill", joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> skills;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "availability_id")
    private AvailabilityEntity availability;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ContractEntity> contracts;
}
