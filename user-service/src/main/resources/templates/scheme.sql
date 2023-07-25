create table users (
    id numeric generated always as identity primary key ,
    first_name varchar(100),
    last_name varchar(100),
    username varchar(100),
    email varchar(100),
    address varchar(256),
    country_id numeric,
    state_id numeric,
    card_name varchar(50),
    card_number varchar(50),
    expiration varchar(10),
    cvv varchar(50),
    foreign key (country_id) references country(id),
    foreign key (state_id) references state(id)
);

create table country(
    id numeric generated always as identity primary key ,
    name varchar(50)
);

create table state(
    id numeric generated always as identity primary key ,
    name varchar(50),
    zip_code varchar(50)
);
