insert into COUNTRY(NAME) values ('uzbekistan');

insert into STATE(name, zip_code) values ('Fargona','150508');

insert into USERS(FIRST_NAME, LAST_NAME, USERNAME, EMAIL, ADDRESS, COUNTRY_ID, STATE_ID, CARD_NAME, CARD_NUMBER, EXPIRATION, CVV)
VALUES ( 'Rahul','Sharma','rahul','rahul@gmail.com','Fargona district 108-A',1,1,'uzcard','9860152378955689','10/29','175899');

commit ;