create table Cam
(
        id int primary key auto_increment,
        ativo varchar(10) not null unique,
        mac varchar(17) not null unique,
        modelo varchar(50) not null
);