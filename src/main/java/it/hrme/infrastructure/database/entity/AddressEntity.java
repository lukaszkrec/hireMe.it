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
@Table(name = "address")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"candidate", "company"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
public class AddressEntity extends BaseEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "street")
    private String street;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private CandidateEntity candidate;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private CompanyEntity company;
}
