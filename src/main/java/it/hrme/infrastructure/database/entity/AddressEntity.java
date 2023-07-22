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
@Table(name = "address")
public class AddressEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "street")
    private String street;

    @OneToOne(mappedBy = "addressEntity", fetch = FetchType.LAZY)
    private CandidateEntity candidateEntity;

    @OneToOne(mappedBy = "addressEntity", fetch = FetchType.LAZY)
    private CompanyEntity companyEntity;
}
