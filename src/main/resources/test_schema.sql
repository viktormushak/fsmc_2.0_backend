create table raw_data (
    id           int auto_increment primary key,
    company varchar(50) not null,
    address_id       int not null,
    address    varchar(200) not null,
    person_id       int not null,
    person   varchar(200) not null,
    sku_id       int not null,
    sku       varchar(200) not null,
    brand       varchar(200),
    quantity     double
);

create table companies (
    id          int auto_increment  primary key,
    company     varchar(50) null,
    last_update bigint  null,
    constraint companies_company_uindex unique (company)
);

create table clients_data(
    id int auto_increment primary key,
    hash_id    int          null,
    name       varchar(100) null,
    surname    varchar(100) null,
    patronymic varchar(100) null,
    phone      varchar(20)  null,
    email      varchar(100) null,
    constraint clients_data_has_id_uindex
        unique (hash_id)
);

create table clients_address (
    id      int auto_increment primary key,
    hash_id int          null,
    region  varchar(100) null,
    city    varchar(100) null,
    street  varchar(100) null,
    constraint clients_address_has_id_uindex
        unique (hash_id)
);