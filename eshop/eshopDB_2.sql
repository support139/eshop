use eshopDB;


create table if not exists Category(
	id int not null auto_increment,
    category varchar(20) not null,
    primary key (id)
) character set utf8 engine InnoDB;

insert into Category values (1, 'Electro guitar'),
							(2, 'Acoustic guitar');

create table if not exists Manufacturer(
	id int not null auto_increment,
    manufacturer varchar(20) not null,
    primary key (id)
) character set utf8 engine InnoDB;

insert into Manufacturer values (1, 'Charvel'),
								(2, 'Esp'),
								(3, 'Fender'),
                                (4, 'Gibson'),
                                (5, 'Maxtone'),
                                (6, 'Cort'),
                                (7, 'Ibanez');

create table if not exists Guitar(
	id int not null auto_increment,
    name varchar(40) not null,
    price double not null,
    body varchar(20) not null,
    scale double not null,
    neck varchar(20) not null,
    fingerboard varchar(20) not null,
    picture varchar (40),
    primary key(id),
    manufacturerId int not null,
    categoryId int not null,
    foreign key(manufacturerId) references Manufacturer(id)
    on delete restrict on update cascade,
    foreign key (categoryId) references Category(id)
    on delete restrict on update cascade    
) character set utf8 engine InnoDB;

insert into Guitar values (1, 'Charvel DC-1', 900, 'Mahogany', 25.5, 'Mahogany', 'Palisander', 'charvel-ds1.jpg', 1, 1),
						  (2, 'Charvel DC-2', 600, 'Mahogany', 25.5, 'Mahogany', 'Palisander', 'charvel-ds2.jpg', 1, 1),
                          (3, 'Charvel DX-1FR', 950, 'Mahogany', 25.5, 'Mahogany', 'Palisander','charvel-dx-1.jpg', 1, 1),
                          (4, 'ESP BS-7ST', 1900, 'Mahogany', 25.5, 'Mahogany', 'Palisander', 'bs7.jpg',  2, 1),
                          (5, 'ESP Eclipse II', 2050, 'Mahogany', 24.75, 'Mahogany', 'Palisander', 'ec2.jpg', 2, 1),
                          (6, 'Fender 60s Stratocaster', 3200, 'Mahogany', 24.75, 'Mahogany', 'Palisander', 'fender1.jpg',  3, 1),
                          (7, 'Fender 60th Anniversary Telecaster', 1400, 'Mahogany', 24.75, 'Mahogany', 'Palisander', 'telec1.jpg', 3, 1),
                          (8, 'Gibson Custom Shop 1957', 3800, 'Mahogany', 24.75, 'Mahogany', 'Palisander', 'gib57.jpg', 4, 1),
                          (9, 'Gibson Explorer 7', 2100, 'Mahogany', 24.75, 'Mahogany', 'Palisander','ex7.jpg',  4, 1),
                          (10, 'Maxtone WGC-3903', 100, 'Mahogany', 25.75, 'Mahogany', 'Palisander','max03.jpg', 5, 2),
                          (11, 'Ibanez PF15', 200, 'Mahogany', 25.75, 'Mahogany', 'Palisander','ib15.jpg', 6, 2),
                          (12, 'Cort AD880', 220, 'Mahogany', 25.75, 'Mahogany', 'Palisander','ad880.jpg', 7, 2);
                          
                          
                          