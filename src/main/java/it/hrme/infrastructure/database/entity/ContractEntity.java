package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract")
@AttributeOverride(name = "id", column = @Column(name = "contract_id"))
public class ContractEntity extends BaseEntity {

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candidate_id")
    private CandidateEntity candidateEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOfferEntity;
}
