create table address (
    id int auto_increment primary key,
    company_id int,
    region varchar(50) null,
    city varchar(50) null,
    street varchar(50) null,
    build  varchar(10) null,
    constraint company_profiles_fk
    foreign key (company_id)  REFERENCES company (id)
);

create table company (
    id int auto_increment primary key,
    company_name varchar(20) not null
);

create table user (
    id int auto_increment primary key,
    username varchar(50) not null,
    password varchar(100) not null,
    authority varchar(10) not null,
    enabled  boolean not null
);

create table profile (
    id int auto_increment primary key,
    user_id int,
    user_name varchar(50),
    user_surname varchar(50),
    email varchar(50),
    phone varchar(50),
    company_id int,
    address_id int,
    constraint user_profiles_fk
    foreign key (user_id)  REFERENCES user (id),
    constraint company_profiles_fk
    foreign key (company_id)  REFERENCES company (id),
    constraint address_profile_fk
    foreign key (address_id)  REFERENCES address (id)
);

