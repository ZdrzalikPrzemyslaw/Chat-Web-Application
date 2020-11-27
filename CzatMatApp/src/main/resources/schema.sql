DROP TABLE IF EXISTS users;
CREATE TABLE users (
id int identity primary key,
login varchar(30) unique,
password varchar(512),
name varchar(50),
surname varchar(50),
email varchar(100),
)