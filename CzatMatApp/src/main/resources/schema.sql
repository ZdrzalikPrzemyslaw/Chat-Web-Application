-- TODO dodać lokalna baze danych uzywana w trakcie developmentu lokalnego, tak aby nie psuć bazy danych w chmurze
DROP TABLE IF EXISTS keys_users;
DROP TABLE IF EXISTS chat_messages;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS chat_users;
DROP TABLE IF EXISTS chats;
DROP TABLE IF EXISTS [users];
DROP TABLE IF EXISTS keys;

CREATE TABLE [users]
(
    id       int identity primary key,
    username varchar(30) unique  not null,
    password varchar(512)        not null,
    name     varchar(50)         not null,
    surname  varchar(50)         not null,
    email    varchar(100) unique not null,
    enabled  int                 not null default 1,
)

CREATE TABLE roles
(
    id   int         not null identity primary key,
    name varchar(30) not null unique,
    CONSTRAINT check_name CHECK (name IN ('ROLE_USER', 'ROLE_SUPER_USER', 'ROLE_ADMIN'))
)

CREATE TABLE authorities
(
    ID        int identity primary key,
    username  varchar(30) not null,
    role_name varchar(30) not null,
    foreign key (username) references [users] (username),
    foreign key (role_name) references [roles] (name),
)

CREATE TABLE chats
(
    ID         int identity primary key,
    owner_id   int         not null,
    name       varchar(30) null,
    created_at DATETIME    not null,
    foreign key (owner_id) references [users] (ID)
)

create table chat_users
(
    id      int identity primary key,
    chat_id int not null,
    user_id int not null,
    unique (chat_id, user_id),
    foreign key (chat_id) references [chats] (ID)
)

CREATE TABLE keys
(
    id      int identity primary key,
    base_id int,
    value   VARCHAR(1024) not null,
)

CREATE TABLE chat_messages
(
    ID          int identity primary key,
    chat_id     int      not null,
    user_id     int      not null,
    file_id     int      null,
    text        varchar(2048),
    created_at  DATETIME not null,
    base_key_id int      null,
    foreign key (chat_id) references [chats] (ID),
    foreign key (user_id) references [users] (id),
)

CREATE TABLE keys_users
(
    id      int identity primary key,
    user_id int not null,
    key_id  int not null,
    foreign key (user_id) references [users] (id),
    foreign key (key_id) references [keys] (id),
    unique (user_id, key_id),
)

insert into roles (name)
values ('ROLE_USER')

insert into roles (name)
values ('ROLE_SUPER_USER')

insert into roles (name)
values ('ROLE_ADMIN')

insert into [users] (username, password, name, surname, email, enabled)
values ('admin', '$2a$10$lgrAbmBcu5S/IQiFijAYDeDp9A39rghMTti/.Kd4idYDtKGJCK1iS', 'Administrator', 'Administracyjny',
        'admin@admin.pl', 1)

insert into authorities(username, role_name)
values ('admin', 'ROLE_ADMIN')

insert into authorities(username, role_name)
values ('admin', 'ROLE_USER')

insert into authorities(username, role_name)
values ('admin', 'ROLE_SUPER_USER')

insert into [users] (username, password, name, surname, email, enabled)
values ('user_zwykly', 'zwykly_user', 'Uzytnik', 'Uzywajacy', 'user@user.pl', 1)

insert into authorities(username, role_name)
values ('user_zwykly', 'ROLE_USER')

insert into [users] (username, password, name, surname, email, enabled)
values ('Przemus', '$2a$10$lgrAbmBcu5S/IQiFijAYDeDp9A39rghMTti/.Kd4idYDtKGJCK1iS', 'Przemek', 'Zdrzalus', 'p@z.pl', 1)

insert into authorities(username, role_name)
values ('Przemus', 'ROLE_USER')

insert into authorities(username, role_name)
values ('Przemus', 'ROLE_SUPER_USER')

insert into [users] (username, password, name, surname, email, enabled)
values ('Julcia', '$2a$10$lgrAbmBcu5S/IQiFijAYDeDp9A39rghMTti/.Kd4idYDtKGJCK1iS', 'Julia', 'Szymania', 'J@S.pl', 1)

insert into authorities(username, role_name)
values ('Julcia', 'ROLE_USER')

insert into [users] (username, password, name, surname, email, enabled)
values ('Witek', '$2a$10$lgrAbmBcu5S/IQiFijAYDeDp9A39rghMTti/.Kd4idYDtKGJCK1iS', 'Witeczek', 'Pietrzak', 'W@P.pl', 1)

insert into authorities(username, role_name)
values ('Witek', 'ROLE_USER')

