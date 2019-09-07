create table users (
    id int auto_increment primary key,
    username varchar(50) not null,
    password varchar(100) not null,
    authority varchar(10) not null,
    enabled  boolean not null
);