create table users (
    id int auto_increment primary key,
    username varchar(50) not null,
    password varchar(100) not null,
    authority varchar(10) not null,
    enabled  boolean not null
);

create table profiles (
    id int auto_increment primary key,
    user_id int,
    name varchar(50),
    surname varchar(50),
    email varchar(50),
    phone varchar(50),
    constraint users_profiles_fk
    foreign key (user_id)  REFERENCES users (id) on delete cascade
);

