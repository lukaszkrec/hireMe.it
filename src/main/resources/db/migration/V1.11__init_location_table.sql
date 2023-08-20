create table location
(
    location_id bigserial    not null,
    country     varchar(255) not null,
    city        varchar(255) not null,
    postal_code varchar(255) not null,
    address     varchar(255) not null,
    uuid        varchar(255) not null,
    primary key (location_id),
    unique (location_id)
);
