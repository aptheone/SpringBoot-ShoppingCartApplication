delete from product;
commit;

insert into product(product_id,product_name,product_category,price) values(100,'Spring','Books',2000.0);
insert into product(product_id,product_name,product_category,price) values(101,'Java','Books',1000.0);
insert into product(product_id,product_name,product_category,price) values(102,'Hibernate','Books',1000.0);
insert into product(product_id,product_name,product_category,price) values(103,'Spring boot','Books',3000.0);

insert into product(product_id,product_name,product_category,price) values(104,'Jeans','Apparal',2000.0);
insert into product(product_id,product_name,product_category,price) values(105,'T-shirt','Apparal',1000.0);
insert into product(product_id,product_name,product_category,price) values(106,'Tie','Apparal',1000.0);
insert into product(product_id,product_name,product_category,price) values(107,'Suite','Apparal',3000.0);

commit;

delete from Books;
commit;

insert into Books(authour,genre,publications,product_id) values('AP','education','TMH',100);
insert into Books(authour,genre,publications,product_id) values('Martin','education','ABC',101);
insert into Books(authour,genre,publications,product_id) values('Coreman','education','MCG',102);

delete from Apparal;
commit;
insert into Apparal(brand,design,type,product_id) values('Rymond','Freestyle','Grey Suite',107);
insert into Apparal(brand,design,type,product_id) values('Tommy','Freestyle','Grey trouser',104);
insert into Apparal(brand,design,type,product_id) values('Ck','Freestyle','Grey tie',106);
commit;


delete from users;
commit;

INSERT INTO USERS (user_id,user_name,user_email_id,user_phone_no,user_address) VALUES(1, 'Anand','Anand@gmail.com',1240474205,'305 W side Dr MD');
INSERT INTO USERS (user_id,user_name,user_email_id,user_phone_no,user_address) VALUES(2, 'Rojer','ross@gmail.com',1240474255,'307 W side Dr MD');

commit;

delete from cart;
commit;

INSERT INTO CART (cart_id,user_id) VALUES(100, 1);
INSERT INTO CART (cart_id,user_id) VALUES(101, 2);
commit;
commit;