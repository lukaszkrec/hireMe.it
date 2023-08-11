package it.hrme.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
public class CompanyEntity extends BaseEntity {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "industry")
    private String industry;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "companyEntity", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<AgentEntity> agentEntities;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;
}
