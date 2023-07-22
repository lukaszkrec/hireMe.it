create table language
(
    language_id    bigserial    not null,
    language_name           varchar(255) not null,
    language_level varchar(255) not null,
    uuid           varchar(255) not null,
    skill_id       bigint       not null,
    primary key (language_id),
    unique (language_id),
    constraint fk_language_skill
        foreign key (skill_id)
            references skill (skill_id)
);
