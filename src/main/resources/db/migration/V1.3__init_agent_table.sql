create table agent
(
    agent_id     bigserial    not null,
    first_name   varchar(255) not null,
    last_name    varchar(255) not null,
    phone_number varchar(255) not null,
    email        varchar(255) not null,
    uuid         varchar(255) not null,
    company_id   bigint       not null,
    primary key (agent_id),
    unique (agent_id, email, phone_number),
    constraint fk_agent_company
        foreign key (company_id)
            references company (company_id)
);
