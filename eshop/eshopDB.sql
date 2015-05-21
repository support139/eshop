create database if not exists eshopDB 
character set utf8;

use eshopDB;

drop table Users;

create table if not exists Users(
	id int not null auto_increment,
    login varchar(20) not null unique,
    password varchar(20) not null,
    name varchar(20) not null,
    surname varchar(20) not null,
    email varchar(20) not null unique,
    avatar varchar(40) not null,
    primary key (id)
) character set utf8 engine InnoDB;

insert into users values (default, "stat", "stat", "Jason", "Statham", "statham1@gmail.com", "statham"),
						 (default, "merk", "merk", "Angela", "Merkel", "merkel1@gmail.com", "merkel");
						




    

