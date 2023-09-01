create table job_offer_employment_form
(
    job_offer_employment_form_id bigserial not null,
    employment_form_id           bigint    not null,
    job_offer_id                 bigint    not null,
    primary key (job_offer_employment_form_id),
    constraint fk_job_offer_employment_form_employment_form
        foreign key (employment_form_id)
            references employment_form (employment_form_id),
    constraint fk_job_offer_employment_form_employment_form_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
