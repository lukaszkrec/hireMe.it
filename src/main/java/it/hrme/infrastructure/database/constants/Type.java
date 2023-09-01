package it.hrme.infrastructure.database.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {
    REMOTE("Remote"), STATIONARY("Stationary"), HYBRID("Hybrid");

    private final String label;
}
