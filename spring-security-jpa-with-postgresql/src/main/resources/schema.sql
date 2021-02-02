create table users(
                      user_name varchar(50) not null primary key,
                      password varchar(50) not null,
                      roles varchar(200) not null,
                      enabled boolean not null
);