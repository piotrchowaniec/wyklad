CREATE SEQUENCE uses_id_seq;

CREATE TABLE users
(
    user_id    bigint DEFAULT nextval('uses_id_seq') PRIMARY KEY,
    username   VARCHAR(50) UNIQUE  NOT NULL,
    password   VARCHAR(50)         NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_on TIMESTAMP           NOT NULL,
    last_login TIMESTAMP
);