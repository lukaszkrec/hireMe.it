package it.hrme.infrastructure.database.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SkillName {
    JAVA("Java"), C_SHARP("C#"), PYTHON("Python"), JAVA_SCRIPT("JavaScript"), SQL("SQL"), C_PLUS_PLUS("C++");

    private final String label;
}
