create table certification
(
    certification_id   bigserial    not null,
    certification_name varchar(255) not null,
    uuid               varchar(255) not null,
    skill_id           bigint       not null,
    primary key (certification_id),
    unique (certification_id),
    constraint fk_certification_skill
        foreign key (skill_id)
            references skill (skill_id)
);
