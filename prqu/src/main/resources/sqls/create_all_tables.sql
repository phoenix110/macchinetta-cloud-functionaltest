BEGIN;

DROP TABLE IF EXISTS ACCOUNT CASCADE;

CREATE TABLE ACCOUNT (
  USER_ID VARCHAR(10) NOT NULL,
  PASSWORD  VARCHAR(60) NOT NULL,
  FIRST_NAME VARCHAR(128) NOT NULL,
  LAST_NAME VARCHAR(128) NOT NULL,
  PREMIUM boolean NOT NULL DEFAULT false
);

ALTER TABLE ACCOUNT ADD CONSTRAINT PK_ACCOUNT PRIMARY KEY (USER_ID);

DROP TABLE IF EXISTS MESSAGE_ID CASCADE;

CREATE TABLE MESSAGE_ID (
  QUEUE_NAME VARCHAR(50),
  ID VARCHAR(50),
  PRIMARY KEY (QUEUE_NAME, ID)
);

DROP TABLE IF EXISTS FT_MESSAGE CASCADE;

CREATE TABLE FT_MESSAGE (
  REQUEST_ID VARCHAR(36),
  MESSAGE VARCHAR(100),
  REQUESTED_AT timestamp,
  PROCESSED_AT timestamp,
  PRIMARY KEY (REQUEST_ID)
);



COMMIT;