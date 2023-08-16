package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "company")
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"agents", "address"}, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
public class CompanyEntity extends BaseEntity {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "industry")
    private String industry;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<AgentEntity> agents;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
}
