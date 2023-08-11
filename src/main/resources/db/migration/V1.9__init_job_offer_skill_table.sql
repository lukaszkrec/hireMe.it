create table job_offer_skill
(
    job_offer_skill_id bigserial not null,
    skill_id           bigint    not null,
    job_offer_id       bigint    not null,
    primary key (job_offer_id),
    unique (job_offer_id),
    constraint fk_job_offer_skill_skill
        foreign key (skill_id)
            references skill (skill_id),
    constraint fk_job_offer_skill_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
