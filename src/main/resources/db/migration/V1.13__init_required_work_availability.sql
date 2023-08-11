create table required_work_availability
(
    required_work_availability_id bigserial    not null,
    work_availability             varchar(255) not null,
    uuid                          varchar(255) not null,
    job_offer_id                  bigint       not null,
    primary key (required_work_availability_id),
    unique (required_work_availability_id),
    constraint fk_work_time_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
