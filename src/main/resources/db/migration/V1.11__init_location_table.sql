create table location
(
    location_id  bigserial    not null,
    country      varchar(255) not null,
    city         varchar(255) not null,
    postal_code  varchar(255) not null,
    address      varchar(255) not null,
    uuid         varchar(255) not null,
    job_offer_id bigint       not null,
    primary key (location_id),
    unique (location_id),
    constraint fk_location_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
