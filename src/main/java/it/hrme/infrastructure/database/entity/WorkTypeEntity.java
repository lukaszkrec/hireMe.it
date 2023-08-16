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
@Table(name = "work_type")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"jobOffer"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "work_type_id"))
public class WorkTypeEntity extends BaseEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;

    public enum Type {
        REMOTE, STATIONARY, HYBRID
    }
}
