create table customers(
id int auto_increment primary key,
name varchar(40) not null,
address varchar(200),
email varchar(50)
);
create table orders(
order_id int auto_increment primary key,
staff varchar(50),
customer_id int,
foreign key (order_id) references customers(id)
);