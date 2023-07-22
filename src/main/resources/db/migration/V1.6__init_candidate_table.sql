create table candidate
(
    candidate_id    bigserial    not null,
    first_name      varchar(255) not null,
    last_name       varchar(255) not null,
    phone           varchar(255) not null,
    email           varchar(255) not null,
    photo           bytea        not null,
    overview        varchar(255) not null,
    work_interest   boolean      not null,
    uuid            varchar(255) not null,
    address_id      bigint       not null,
    availability_id bigint       not null,
    skill_id        bigint       not null,
    primary key (candidate_id),
    unique (candidate_id, email, phone),
    constraint fk_candidate_address
        foreign key (address_id)
            references address (address_id),
    constraint fk_candidate_availability
        foreign key (availability_id)
            references availability (availability_id),
    constraint fk_candidate_skill
        foreign key (skill_id)
            references skill (skill_id)
);
