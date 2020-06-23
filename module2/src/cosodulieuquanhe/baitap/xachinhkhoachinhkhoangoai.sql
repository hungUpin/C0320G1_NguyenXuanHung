create table customers(
customer_number int auto_increment primary key,
full_name varchar(200) not null,
address varchar(300),
phone varchar(50) ,
email varchar(50)
);
create table accounts(
account_number int primary key,
account_type varchar(100),
create_day date,
balance double,
customer_number int, foreign key(customer_number) references customers(customer_number)
);
create table transactions(
tran_number int primary key,
tran_date date,
amounts double,
descriptions varchar(200),
account_number int, foreign key(account_number) references accounts(account_number)
);