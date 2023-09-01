create table contract
(
    contract_id  bigserial    not null,
    start_date   timestamp(6) not null,
    end_date     timestamp(6) not null,
    uuid         varchar(255) not null,
    candidate_id bigint       not null,
    job_offer_id bigint       not null,
    primary key (contract_id),
    unique (uuid),
    constraint fk_contract_candidate
        foreign key (candidate_id)
            references candidate (candidate_id),
    constraint fk_contract_job_offer
        foreign key (job_offer_id)
            references job_offer (job_offer_id)
);
