
create table if not exists client_user(
    seq int auto_increment primary key,
    id varchar(20) unique,
    password varchar(20) not null,
    name varchar(20) not null,
    address varchar(255),
    telno varchar(15),
    userActivate varchar(1) default 'Y'
);

create table if not exists login_log (

    seq int auto_increment primary key,
    id varchar(20) not null,
    ip varchar(40),
    login_status char(1) not null,
    login_dttm TIMESTAMP  DEFAULT  CURRENT_TIMESTAMP
);