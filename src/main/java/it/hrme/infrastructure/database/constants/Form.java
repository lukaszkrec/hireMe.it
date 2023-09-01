package it.hrme.infrastructure.database.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Form {
    B2B("B2B"), EMPLOYMENT_CONTRACT("Employment contract");

    private final String label;
}
