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
    last_update bigint  null
);

