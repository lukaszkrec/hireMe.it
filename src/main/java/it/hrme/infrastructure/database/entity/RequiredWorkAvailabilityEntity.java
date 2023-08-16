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
@Table(name = "required_work_availability")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"jobOffer"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "required_work_availability_id"))
public class RequiredWorkAvailabilityEntity extends BaseEntity {

    @Column(name = "work_availability")
    @Enumerated(EnumType.STRING)
    private WorkAvailability workAvailability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;

    public enum WorkAvailability {
        FULL_TIME, PART_TIME
    }
}
