create table users (
	id bigint not null auto_increment,
    name varchar(60) not null,
    email varchar(255) not null,
    cpf varchar(11) not null,
    birthdate date not null,
    
    primary key (id)
);