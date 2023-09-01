create table employment_form
(
    employment_form_id bigserial    not null,
    form               varchar(255) not null,
    uuid               varchar(255) not null,
    primary key (employment_form_id),
    unique (uuid)
);
