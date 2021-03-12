create table vaccine_application (
	id bigint not null auto_increment,
    emailusers varchar(255) not null,
    applicationdate date not null,
    
    primary key (id)
);