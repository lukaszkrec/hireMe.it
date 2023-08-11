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
@Table(name = "required_work_availability")
@AttributeOverride(name = "id", column = @Column(name = "required_work_availability_id"))
public class RequiredWorkAvailability extends BaseEntity {

    @Column(name = "required_work_availability")
    @Enumerated(EnumType.STRING)
    private WorkAvailability workAvailability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOfferEntity;
}
