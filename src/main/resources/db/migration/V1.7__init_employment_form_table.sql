create table employment_form
(
    employment_form_id bigserial    not null,
    form               varchar(255) not null,
    uuid               varchar(255),
    primary key (employment_form_id),
    unique (employment_form_id)
);
