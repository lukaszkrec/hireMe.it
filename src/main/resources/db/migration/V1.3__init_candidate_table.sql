create table candidate
(
    candidate_id     bigserial    not null,
    first_name       varchar(255) not null,
    last_name        varchar(255) not null,
    phone            varchar(255) not null,
    email            varchar(255) not null,
    photo            oid          not null,
    overview         varchar(255) not null,
    work_interest    boolean      not null,
    candidate_status varchar(255) not null,
    uuid             varchar(255) not null,
    primary key (candidate_id),
    unique (email, phone, uuid)
);


