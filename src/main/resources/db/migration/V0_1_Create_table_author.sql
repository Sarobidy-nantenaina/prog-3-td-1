create table author
(
    id     serial,
    name varchar unique,
    particularity  varchar,
    birthdate date,
    primary key (id)
);