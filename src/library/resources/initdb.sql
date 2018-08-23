drop table if exists users;
create table users(
    id bigserial not null primary key,
    login varchar(64) not null unique,
    password varchar(32) not null
);

drop table if exists authors;
create table authors(
    id bigserial not null primary key,
    firstname varchar(64) not null,
    lastname varchar(64) not null,
    middlename varchar(64)
);

drop table if exists publishers;
create table publishers(
    id bigserial not null primary key,
    title varchar(64) not null,
    phonenumber char(12),
    email varchar(64) ,
    address varchar(128)
);

drop table if exists books;
create table books(
    id bigserial not null primary key,
    title varchar(128) not null,
    author_id bigint not null,
    publisher_id bigint not null,
    description varchar(500),
    constraint fk_author foreign key (author_id) references authors(id),
    constraint fk_publisher foreign key (publisher_id) references publishers(id)
);