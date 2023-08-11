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
@Table(name = "language")
@AttributeOverride(name = "id", column = @Column(name = "language_id"))
public class LanguageEntity extends BaseEntity {

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private String languageLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private SkillEntity skillEntity;
}
