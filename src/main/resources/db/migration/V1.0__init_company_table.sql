create table company
(
    company_id   bigserial    not null,
    company_name varchar(255) not null,
    description  varchar(255) not null,
    industry     varchar(255) not null,
    uuid         varchar(255) not null,
    primary key (company_id),
    unique (uuid)
);
