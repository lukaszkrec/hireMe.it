package it.hrme.infrastructure.database.entity;

import it.hrme.infrastructure.database.constants.WorkAvailability;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "required_work_availability")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"jobOffers"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "required_work_availability_id"))
public class RequiredWorkAvailabilityEntity extends BaseEntity {

    @Column(name = "work_availability")
    @Enumerated(EnumType.STRING)
    private WorkAvailability workAvailability;

    @Builder.Default
    @ManyToMany(mappedBy = "requiredWorkAvailabilities")
    private Set<JobOfferEntity> jobOffers = new HashSet<>();
}
