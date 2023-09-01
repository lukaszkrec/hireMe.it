package it.hrme.infrastructure.database.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkAvailability {
    FULL_TIME("Full time"), PART_TIME("Part time");

    private final String label;
}
