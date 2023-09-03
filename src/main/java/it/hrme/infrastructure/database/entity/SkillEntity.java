package it.hrme.infrastructure.database.entity;

import it.hrme.infrastructure.database.constants.SkillName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "skill")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "skill_id"))
public class SkillEntity extends BaseEntity {

    @Column(name = "skill_name")
    @Enumerated(EnumType.STRING)
    private SkillName skillName;
}
