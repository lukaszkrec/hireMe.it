create table job_offer_location
(
    job_offer_location_id bigserial not null,
    location_id           bigint    not null,
    job_offer_id          bigint,
    primary key (job_offer_location_id),
    unique (job_offer_location_id),
    constraint fk_job_offer_location_location
        foreign key (location_id)
            references location (location_id),
    constraint fk_job_offer_location_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);

