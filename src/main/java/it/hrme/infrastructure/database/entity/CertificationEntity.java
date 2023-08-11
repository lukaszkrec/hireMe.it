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
@Table(name = "certification")
@AttributeOverride(name = "id", column = @Column(name = "certification_id"))
public class CertificationEntity extends BaseEntity {

    @Column(name = "certification_name")
    private String certificationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private SkillEntity skillEntity;
}

