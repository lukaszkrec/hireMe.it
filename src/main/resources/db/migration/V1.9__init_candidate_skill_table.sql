create table candidate_skill
(
    candidate_skill_id bigserial not null,
    skill_id           bigint    not null,
    candidate_id       bigint    not null,
    primary key (candidate_skill_id),
    unique (candidate_skill_id),
    constraint fk_candidate_skill_skill
        foreign key (skill_id)
            references skill (skill_id),
    constraint fk_candidate_skill_candidate
        foreign key (candidate_id)
            references candidate (candidate_id)
);
