create table availability
(
    availability_id bigserial    not null,
    status          varchar(255) not null,
    uuid            varchar(255) not null,
    primary key (availability_id)
);
