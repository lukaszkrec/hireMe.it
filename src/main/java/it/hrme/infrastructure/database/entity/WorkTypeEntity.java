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
@Table(name = "work_type")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"jobOffers"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "work_type_id"))
public class WorkTypeEntity extends BaseEntity {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder.Default
    @ManyToMany(mappedBy = "workTypes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<JobOfferEntity> jobOffers = new HashSet<>();

    public enum Type {
        REMOTE, STATIONARY, HYBRID
    }
}
