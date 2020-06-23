create table users(
user_id int(10) auto_increment primary key,
username varchar(30) not null,
password varchar(30),
email varchar(40)
);
create table roles(
role_id int auto_increment,
role_name nvarchar(30),
primary key(role_id)
);
create table userroles(
user_id int not null,
role_id int not null,
primary key(user_id,role_id),
foreign key(user_id) references users(user_id),
foreign key(role_id) references roles(role_id)
);
alter table roles add primary key (role_name);