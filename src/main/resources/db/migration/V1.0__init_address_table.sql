create table address
(
    address_id  bigserial    not null,
    country     varchar(255) not null,
    city        varchar(255) not null,
    postal_code varchar(255) not null,
    street      varchar(255) not null,
    uuid        varchar(255) not null,
    primary key (address_id),
    unique (address_id)
);
