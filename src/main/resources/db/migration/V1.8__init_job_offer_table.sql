create table job_offer
(
    job_offer_id   bigserial      not null,
    title          varchar(255)   not null,
    description    varchar(255)   not null,
    salary         numeric(38, 2) not null,
    date_published timestamp(6)   not null,
    uuid           varchar(255)   not null,
    skill_id       bigint         not null,
    agent_id       bigint         not null,
    primary key (job_offer_id),
    unique (job_offer_id),
    constraint fk_job_offer_skill
        foreign key (skill_id)
            references skill (skill_id),
    constraint fk_job_offer_agent
        foreign key (agent_id)
            references agent (agent_id)
);

