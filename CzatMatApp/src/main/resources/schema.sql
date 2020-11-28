DROP TABLE IF EXISTS users;
CREATE TABLE users (
id int identity primary key,
login varchar(30) unique not null ,
password varchar(512) not null ,
name varchar(50) not null ,
surname varchar(50) not null ,
email varchar(100) not null ,
)

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
    login varchar(30) not null primary key,
    authority varchar(50) not null,
    foreign key (login) references users (login)
)

insert into users (login, password, name, surname, email) values ('admin', 'admin', 'Administrator', 'Administracyjny', 'admin@admin.pl')
insert into authorities(login, authority) values ('admin', 'ROLE_ADMIN')

insert into users (login, password, name, surname, email) values ('user_zwykly', 'zwykly_user', 'Uzytnik', 'Uzywajacy', 'user@user.pl')
insert into authorities(login, authority) values ('user_zwykli', 'ROLE_USER')