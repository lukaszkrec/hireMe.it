create table skill
(
    skill_id   bigserial    not null,
    skill_name varchar(255) not null,
    uuid       varchar(255) not null,
    primary key (skill_id),
    unique (skill_name, uuid)
);
