DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       int identity primary key,
    username    varchar(30) unique not null,
    password varchar(512)       not null,
    name     varchar(50)        not null,
    surname  varchar(50)        not null,
    email    varchar(100)       not null,
)

CREATE TABLE authorities
(
    username     varchar(30) not null primary key,
    authority varchar(50) not null,
    foreign key (username) references users (username)
)

-- TODO
insert into users (username, password, name, surname, email)
values ('admin', 'admin', 'Administrator', 'Administracyjny', 'admin@admin.pl')

insert into authorities(username, authority)
values ('admin', 'ROLE_ADMIN')

insert into users (username, password, name, surname, email)
values ('user_zwykly', 'zwykly_user', 'Uzytnik', 'Uzywajacy', 'user@user.pl')

insert into authorities(username, authority)
values ('user_zwykli', 'ROLE_USER')
