BEGIN;

INSERT INTO ACCOUNT (USER_ID, PASSWORD, FIRST_NAME, LAST_NAME) VALUES ('0000000001', '$2a$10$Qw2MNZOa5tHZUhp5clz.5esaVy4NQioc2xvXBYyUcwBPhha.hxgOu', 'Hanako', 'Denden');
INSERT INTO ACCOUNT (USER_ID, PASSWORD, FIRST_NAME, LAST_NAME) VALUES ('0000000002', '$2a$10$Qw2MNZOa5tHZUhp5clz.5esaVy4NQioc2xvXBYyUcwBPhha.hxgOu', 'Taro', 'Denden');

INSERT INTO RDRP2_USER (FIRST_NAME, LAST_NAME) VALUES ('Hanako', 'Denden');
INSERT INTO RDRP2_USER (FIRST_NAME, LAST_NAME) VALUES ('Taro', 'Denden');

COMMIT;