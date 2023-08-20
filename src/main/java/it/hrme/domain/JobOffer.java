package it.hrme.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@With
@Value
@Builder
@ToString(
        exclude = {"skills", "agent", "contract", "workTypes",
                "requiredWorkAvailabilities", "employmentForms", "locations"}
)
@EqualsAndHashCode(of = "uuid")
public class JobOffer {

    Long id;
    String uuid;
    String title;
    String description;
    BigDecimal salary;
    LocalDate datePublished;
    @Builder.Default
    Set<Skill> skills = new HashSet<>();
    Agent agent;
    Contract contract;
    @Builder.Default
    Set<WorkType> workTypes = new HashSet<>();
    @Builder.Default
    Set<RequiredWorkAvailability> requiredWorkAvailabilities = new HashSet<>();
    @Builder.Default
    Set<EmploymentForm> employmentForms = new HashSet<>();
    @Builder.Default
    Set<Location> locations = new HashSet<>();

    public void addSkill(Skill skillEntity) {
        this.skills.add(skillEntity);
    }

    public void remove(Skill skillEntity) {
        this.skills.remove(skillEntity);
    }
}
