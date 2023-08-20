package it.hrme.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@ToString
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(of = "uuid")
public abstract class BaseEntity {

    @Builder.Default
    @Column(name = "uuid")
    private final String uuid = UUID.randomUUID().toString();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
