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

create table last_company_update (
    id          int auto_increment  primary key,
    company     varchar(50) null,
    last_update mediumtext  null,
    constraint update_company_name_uindex
    unique (company)
);

