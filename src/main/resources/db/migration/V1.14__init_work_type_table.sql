create table work_type
(
    work_type_id bigserial    not null,
    type         varchar(255) not null,
    uuid         varchar(255) not null,
    primary key (work_type_id),
    unique (uuid)
);
