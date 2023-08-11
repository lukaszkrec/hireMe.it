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
@Table(name = "employment_form")
@AttributeOverride(name = "id", column = @Column(name = "employment_form_id"))
public class EmploymentFormEntity extends BaseEntity {

    @Column(name = "form")
    @Enumerated(EnumType.STRING)
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOfferEntity;
}
