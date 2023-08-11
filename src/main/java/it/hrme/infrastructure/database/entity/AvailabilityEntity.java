package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "availability")
@AttributeOverride(name = "id", column = @Column(name = "availability_id"))
public class AvailabilityEntity extends BaseEntity {

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "availabilityEntity")
    private CandidateEntity candidateEntity;
}
