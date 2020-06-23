create table catogories(
catogory_id int auto_increment primary key,
catogory_name varchar(200)
);
create table products(
product_id int auto_increment primary key,
product_name varchar(200),
price double,
image_url varchar(200),
discount double,
stock int,
catogory_id int, foreign key (catogory_id) references catogories(catogory_id),
supplier_id int, foreign key (supplier_id) references supplier(supplier_id)
);
create table customer(
customer_id int auto_increment primary key,
customer_name varchar(200),
customer_address varchar(250),
customer_phone varchar(50),
customer_email varchar(50)
);
create table supplier(
supplier_id int auto_increment primary key,
supplier_name varchar(200),
supplier_phone varchar(50),
supplier_address varchar(200)
);
create table employee(
employee_id int auto_increment primary key,
employee_name varchar(200),
employee_birth date,
employee_address varchar(250),
employee_phone varchar(50),
employee_email varchar(50)
);
create table order_product(
order_id int auto_increment primary key,
order_status varchar(100),
payment double,
customer_id int, foreign key (customer_id) references customer(customer_id),
employee_id int, foreign key (employee_id) references employee(employee_id)
);
create table order_detail(
product_id int,
order_id int,
primary key(product_id,order_id),
foreign key(product_id) references products(product_id),
foreign key(order_id) references order_product(order_id)
);