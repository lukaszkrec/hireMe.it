package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "candidate")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"skills", "address", "contracts"}, callSuper = true)
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
    @Builder.Default
    private boolean workInterest = true;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "candidate_skill",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<SkillEntity> skills = new HashSet<>();

    @Builder.Default
    @Column(name = "candidate_status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    @Builder.Default
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ContractEntity> contracts = new HashSet<>();

    @Getter
    @AllArgsConstructor
    public enum Status {
        ACTIVE("Active"), SUSPENDED("Suspended");

        private final String label;
    }
}
