create table orders(
                       id NUMBER generated as identity not null unique,
                       username varchar2(256) not null unique,
                       total_price number,
                       firstname varchar2(256) not null,
                       lastname varchar2(256) not null,
                       email_address varchar2(256) not null unique ,
                       address_line varchar2(256),
                       country varchar2(256),
                       state varchar2(256),
                       zip_code varchar2(256),
                       card_name varchar2(32),
                       card_number varchar2(32),
                       expiration varchar2(6),
                       cvv varchar2(12));

create table products(
    id varchar2(50) not null primary key,
    quantity INTEGER,
    imageFile varchar2(256),
    price NUMBER,
    product_name VARCHAR(256),
    order_id NUMBER,
    foreign key (order_id) references orders(id)
)
