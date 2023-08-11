create table work_type
(
    work_type_id bigserial    not null,
    type         varchar(255) not null,
    uuid         varchar(255) not null,
    job_offer_id bigint       not null,
    primary key (work_type_id),
    unique (work_type_id),
    constraint fk_work_type_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
