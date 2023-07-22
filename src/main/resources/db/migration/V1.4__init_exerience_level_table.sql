create table experience_level
(
    experience_level_id bigserial    not null,
    level               varchar(255) not null,
    uuid                varchar(255) not null,
    primary key (experience_level_id),
    unique (experience_level_id)
);
