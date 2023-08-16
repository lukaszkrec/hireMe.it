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
@Table(name = "location")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "jobOffer", callSuper = true)
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "job_offer_id")
    private JobOfferEntity jobOffer;
}
