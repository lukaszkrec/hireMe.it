package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Entity
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "contract")
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "contract_id"))
public class ContractEntity extends BaseEntity {

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;
}
