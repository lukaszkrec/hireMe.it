create table skill
(
    skill_id            bigserial    not null,
    uuid                varchar(255) not null,
    experience_level_id bigint       not null,
    primary key (skill_id),
    unique (skill_id),
    constraint fk_skill_experience_level
        foreign key (experience_level_id)
            references experience_level (experience_level_id)
);
