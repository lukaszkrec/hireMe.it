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
@Table(name = "candidate")
public class CandidateEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long id;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private SkillEntity skillEntity;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "availability_id")
    private AvailabilityEntity availabilityEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "candidateEntity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ContractEntity> jobContractEntities;
}
