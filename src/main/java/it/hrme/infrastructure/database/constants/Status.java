package it.hrme.infrastructure.database.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE("Active"), SUSPENDED("Suspended");

    private final String label;
}
