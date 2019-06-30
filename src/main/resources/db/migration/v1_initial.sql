CREATE TABLE user
(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    surname varchar(50),
    email varchar(50),
    username varchar(50),
    password varchar(50)
);
CREATE UNIQUE INDEX user_id_uindex ON user (id);