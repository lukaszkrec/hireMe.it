package it.hrme.infrastructure.database.entity;

import it.hrme.infrastructure.database.constants.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Table(name = "candidate")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"skills", "contracts"}, callSuper = true)
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
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "candidate_skill",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<SkillEntity> skills = new HashSet<>();

    @Builder.Default
    @Column(name = "candidate_status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @Builder.Default
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.REMOVE)
    private Set<ContractEntity> contracts = new HashSet<>();


}
