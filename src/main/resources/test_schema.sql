create table raw_data (
    id           int auto_increment primary key,
    company_name varchar(50) not null,
    a_uuid       int not null,
    r_address    varchar(200) not null,
    e_uuid       int not null,
    r_employee   varchar(200) not null,
    s_uuid       int not null,
    r_sale       varchar(200) not null,
    quantity     double
);

create table address (
    id      int auto_increment primary key,
    uuid    int         null,
    region  varchar(50) null,
    city    varchar(50) null,
    street  varchar(50) null,
    building   varchar(10) null,
    constraint address_uuid_uindex
    unique (uuid)
);

create table user (
    id              int auto_increment primary key,
    uuid            int             null,
    username        varchar(100)    null,
    password        varchar(100)    null,
    authority       varchar(10)     null,
    enabled         tinyint         null,
    user_name       varchar(50)     null,
    user_surname    varchar(50)     null,
    user_patronymic varchar(50)     null,
    email           varchar(50)     null,
    phone           varchar(50)     null,
    constraint user_uuid_uindex
    unique (uuid)
);

