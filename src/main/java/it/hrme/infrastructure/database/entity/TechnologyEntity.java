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
@Table(name = "technology")
@AttributeOverride(name = "id", column = @Column(name = "technology_id"))
public class TechnologyEntity extends BaseEntity {

    @Column(name = "technology_name")
    private String technologyName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private SkillEntity skillEntity;
}
