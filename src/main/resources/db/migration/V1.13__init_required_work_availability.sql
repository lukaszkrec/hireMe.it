create table required_work_availability
(
    required_work_availability_id bigserial    not null,
    work_availability             varchar(255) not null,
    uuid                          varchar(255) not null,
    primary key (required_work_availability_id),
    unique (required_work_availability_id)
);
