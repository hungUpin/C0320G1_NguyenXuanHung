CREATE TABLE contacts(
contact_id INT(11) NOT NUll auto_increment,
last_name varchar(50) NOT NULL,
first_name varchar(30),
birthday DATE,
constraint contacts_pk primary key(contact_id,last_name)
);
create table supppliers
(
supplier_id int(12) not null auto_increment,
supplier_name nvarchar(50) not null,
accoun_rep varchar(30) not null default 'TDB',
primary key(supplier_id)
);
drop table contacts;
select * from supppliers;
alter table supppliers add hello varchar(50) not null first;
alter table supppliers drop column hello;
alter table supppliers modify hello text(20) null, modify accoun_rep nvarchar(30) not null; 
insert into supppliers(supplier_id,supplier_name,accoun_rep) values (12,"abc","test");
alter table supppliers change column supplier_id id int(20) not null;
alter table supppliers rename to suppliers;