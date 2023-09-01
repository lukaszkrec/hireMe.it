create table job_offer_required_work_availability
(
    job_offer_required_work_availability_id bigserial not null,
    required_work_availability_id           bigint    not null,
    job_offer_id                            bigint    not null,
    primary key (job_offer_required_work_availability_id),
        foreign key (required_work_availability_id)
            references required_work_availability (required_work_availability_id),
    constraint fk_job_offer_required_work_availability_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
