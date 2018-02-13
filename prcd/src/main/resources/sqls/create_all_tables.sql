BEGIN;

CREATE TABLE IF NOT EXISTS ACCOUNT (
  USER_ID VARCHAR(10) NOT NULL,
  PASSWORD  VARCHAR(60) NOT NULL,
  FIRST_NAME VARCHAR(128) NOT NULL,
  LAST_NAME VARCHAR(128) NOT NULL
);

ALTER TABLE ACCOUNT ADD CONSTRAINT PK_ACCOUNT PRIMARY KEY (USER_ID);

CREATE TABLE IF NOT EXISTS USER_ROLE (
  USER_ID VARCHAR(10) NOT NULL,
  ROLE char(4) NOT NULL
);

ALTER TABLE ACCOUNT ADD FOREIGN KEY (USER_ID) REFERENCES ACCOUNT(USER_ID);

COMMIT;