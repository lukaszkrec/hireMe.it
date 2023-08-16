package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "availability")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"candidate"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "availability_id"))
public class AvailabilityEntity extends BaseEntity {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "availability")
    private CandidateEntity candidate;

    public enum Status {
        ACTIVE, SUSPENDED
    }
}
