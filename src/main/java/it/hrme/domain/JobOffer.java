package it.hrme.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    Set<Skill> skills;
    Agent agent;
    Contract contract;
    Set<WorkType> workTypes;
    Set<RequiredWorkAvailability> requiredWorkAvailabilities;
    Set<EmploymentForm> employmentForms;
    Set<Location> locations;

    public void addSkill(Skill skillEntity) {
        this.skills.add(skillEntity);
    }

    public void remove(Skill skillEntity) {
        this.skills.remove(skillEntity);
    }
}
