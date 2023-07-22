package it.hrme.infrastructure.database.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
@MappedSuperclass
abstract class BaseEntity {

    @Column(name = "uuid")
    private String uuid = UUID.randomUUID()
            .toString();
}
