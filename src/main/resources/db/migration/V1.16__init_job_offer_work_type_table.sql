create table job_offer_work_type
(
    job_offer_work_type_id bigserial not null,
    work_type_id           bigint    not null,
    job_offer_id           bigint,
    primary key (job_offer_work_type_id),
    unique (job_offer_work_type_id),
    constraint job_offer_work_type_work_type
        foreign key (work_type_id)
            references work_type (work_type_id),
    constraint job_offer_work_type_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
