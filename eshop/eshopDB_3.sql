use eshopDB;

#drop table Shopper;
#drop table `Order`;
#drop table OrderItem;

create table if not exists Shopper(
	id int not null auto_increment,
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    mobilePhone varchar(30) not null,
    country varchar(30) not null,
    state varchar(30) not null,
    adress varchar(30) not null,
    zipCode varchar(30) not null,
    payment varchar(30) not null,
    primary key(id)
) character set utf8 engine InnoDB;

create table if not exists `Order`(
	id int not null auto_increment,
	orderStatus varchar(40) not null,
    orderDetail varchar(40) not null,
    orderDate date not null,
    shopperId int not null,
    primary key(id),
    foreign key(shopperId) references Shopper(id)
    on delete restrict on update cascade
) character set utf8 engine InnoDB;

create table if not exists OrderItem(
	id int not null auto_increment,
    guitarId int not null,
    quantity int not null,
    price double not null,
    orderId int not null,
    primary key(id),
    foreign key(guitarId) references Guitar(id)
    on delete restrict on update cascade,
    foreign key(orderId) references `Order`(id)
    on delete restrict on update cascade
) character set utf8 engine InnoDB;






