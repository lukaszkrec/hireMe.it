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
public class ExperienceLevelEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_level_id")
    private Long id;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToOne(mappedBy = "experienceLevelEntity", fetch = FetchType.LAZY)
    private SkillEntity skillEntity;
}
