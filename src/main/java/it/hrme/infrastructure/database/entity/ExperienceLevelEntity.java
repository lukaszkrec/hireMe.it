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
@Table(name = "experience_level")
@AttributeOverride(name = "id", column = @Column(name = "experience_level_id"))
public class ExperienceLevelEntity extends BaseEntity {

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToOne(mappedBy = "experienceLevelEntity", fetch = FetchType.LAZY)
    private SkillEntity skillEntity;
}
