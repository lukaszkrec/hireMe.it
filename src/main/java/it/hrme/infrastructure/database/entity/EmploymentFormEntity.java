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
@Table(name = "employment_form")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"jobOffer"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "employment_form_id"))
public class EmploymentFormEntity extends BaseEntity {

    @Column(name = "form")
    @Enumerated(EnumType.STRING)
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;

    public enum Form {
        B2B, EMPLOYMENT_CONTRACT
    }
}
