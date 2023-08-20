package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "employment_form")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"jobOffers"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "employment_form_id"))
public class EmploymentFormEntity extends BaseEntity {

    @Column(name = "form")
    @Enumerated(EnumType.STRING)
    private Form form;

    @Builder.Default
    @ManyToMany(mappedBy = "employmentForms", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<JobOfferEntity> jobOffers = new HashSet<>();

    public enum Form {
        B2B, EMPLOYMENT_CONTRACT
    }
}
