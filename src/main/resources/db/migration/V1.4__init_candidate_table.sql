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
    address_id       bigint       not null,
    primary key (candidate_id),
    unique (candidate_id, email, phone),
    constraint fk_candidate_address
        foreign key (address_id)
            references address (address_id)
);


