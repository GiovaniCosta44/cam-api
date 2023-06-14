create table Cam
(
        id int primary key auto_increment,
        ativo varchar(150) not null unique,
        mac varchar(250) not null unique,
        modelo varchar(50) not null
);