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
@Table(name = "location")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "jobOffers", callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "location_id"))
public class LocationEntity extends BaseEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @Builder.Default
    @ManyToMany(mappedBy = "locations", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<JobOfferEntity> jobOffers = new HashSet<>();

}
