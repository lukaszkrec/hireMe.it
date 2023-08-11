create table employment_form
(
    employment_form_id bigserial    not null,
    form               varchar(255) not null,
    uuid               varchar(255),
    job_offer_id       bigint       not null,
    primary key (employment_form_id),
    unique (employment_form_id),
    constraint fk_employment_form_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
