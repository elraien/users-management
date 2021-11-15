DROP DATABASE IF EXISTS `user_management`;
CREATE DATABASE `user_management`;
USE `user_management`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

DROP TABLE IF EXISTS user_management.users;

create TABLE users (
                       id INT PRIMARY KEY,
                       version INT NOT NULL,
                       name VARCHAR(30) NOT NULL
);

insert into users (id, version, name) values (1, 1, 'Alice');
insert into users (id, version, name) values (2, 2, 'Bob');
insert into users (id, version, name) values (3, 1, 'Eve');


DROP TABLE IF EXISTS user_management.units;

create TABLE units (
                       id INT PRIMARY KEY,
                       version INT NOT NULL,
                       name VARCHAR(255) NOT NULL
);

insert into units (id, version, name) values (11, 2, 'Kreftregisteret');
insert into units (id, version, name) values (12, 1, 'Akershus universitetssykehus HF');
insert into units (id, version, name) values (13, 2, 'Sørlandet sykehus HF');
insert into units (id, version, name) values (14, 2, 'Vestre Viken HF');


DROP TABLE IF EXISTS user_management.roles;

create TABLE roles (
                       id INT PRIMARY KEY,
                       version INT NOT NULL,
                       name VARCHAR(100) NOT NULL
);

insert into roles (id, version, name) values (101, 1, 'User administration');
insert into roles (id, version, name) values (102, 2, 'Endoscopist administration');
insert into roles (id, version, name) values (103, 1, 'Report colonoscopy capacity');
insert into roles (id, version, name) values (104, 2, 'Send invitations');
insert into roles (id, version, name) values (105, 1, 'View statistics');


DROP TABLE IF EXISTS user_management.user_roles;

create TABLE user_roles (
                            id INT PRIMARY KEY,
                            version INT NOT NULL,
                            valid_from DATETIME NOT NULL,
                            valid_to DATETIME,
                            role_id INT,
                            unit_id INT,
                            user_id INT,
                            FOREIGN KEY(role_id) REFERENCES roles(id),
                            FOREIGN KEY(unit_id) REFERENCES units(id),
                            FOREIGN KEY(user_id) REFERENCES users(id)
);

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1001, 1, '2019-01-02 00:00:00', '2019-12-31 23:59:59',
        (SELECT id from roles where name = 'User administration'),
        (SELECT id from units where name = 'Kreftregisteret'),
        (SELECT id from users where name = 'Alice')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1002, 2, '2019-01-02 00:00:00', '2019-12-31 23:59:59',
        (SELECT id from roles where name = 'Send invitations'),
        (SELECT id from units where name = 'Kreftregisteret'),
        (SELECT id from users where name = 'Alice')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1003, 1, '2019-06-11 00:00:00', '2019-12-31 23:59:59',
        (SELECT id from roles where name = 'View statistics'),
        (SELECT id from units where name = 'Kreftregisteret'),
        (SELECT id from users where name = 'Alice')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1004, 2, '2020-01-28 00:00:00', null,
        (SELECT id from roles where name = 'User administration'),
        (SELECT id from units where name = 'Akershus universitetssykehus HF'),
        (SELECT id from users where name = 'Bob')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1005, 1, '2020-01-28 00:00:00', null,
        (SELECT id from roles where name = 'View statistics'),
        (SELECT id from units where name = 'Akershus universitetssykehus HF'),
        (SELECT id from users where name = 'Bob')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1006, 1, '2020-01-28 00:00:00', null,
        (SELECT id from roles where name = 'User administration'),
        (SELECT id from units where name = 'Vestre Viken HF'),
        (SELECT id from users where name = 'Bob')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1007, 1, '2020-01-28 00:00:00', null,
        (SELECT id from roles where name = 'Endoscopist administration'),
        (SELECT id from units where name = 'Vestre Viken HF'),
        (SELECT id from users where name = 'Bob')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1008, 1, '2020-02-01 07:00:00', null,
        (SELECT id from roles where name = 'User administration'),
        (SELECT id from units where name = 'Kreftregisteret'),
        (SELECT id from users where name = 'Alice')
       );

insert into user_roles (id, version, valid_from, valid_to, role_id, unit_id, user_id)
values (1009, 1, '2020-02-01 07:00:00', null,
        (SELECT id from roles where name = 'Send invitations'),
        (SELECT id from units where name = 'Kreftregisteret'),
        (SELECT id from users where name = 'Alice')
       );