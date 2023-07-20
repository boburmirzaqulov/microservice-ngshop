create table Coupon(
    id NUMBER(20,0) generated always as identity primary key ,
    product_name varchar(30),
    description varchar2(3000),
    amount NUMBER(10,2)
);

