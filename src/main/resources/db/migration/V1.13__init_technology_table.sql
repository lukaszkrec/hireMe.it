create table technology
(
    technology_id   bigserial    not null,
    technology_name varchar(255) not null,
    uuid            varchar(255) not null,
    skill_id        bigint       not null,
    primary key (technology_id),
    unique (technology_id),
    constraint fk_technology_skill
        foreign key (skill_id)
            references skill (skill_id)
);
