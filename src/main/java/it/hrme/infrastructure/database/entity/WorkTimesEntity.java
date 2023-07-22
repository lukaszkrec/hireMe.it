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
@Table(name = "work_time")
public class WorkTimesEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_time_id")
    private Long id;

    @Column(name = "required_work_availability")
    @Enumerated(EnumType.STRING)
    private RequiredWorkAvailability requiredWorkAvailability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOfferEntity;

    enum RequiredWorkAvailability {
        FULL_TIME, PART_TIME
    }
}
