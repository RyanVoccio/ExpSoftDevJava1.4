CREATE USER IF NOT EXISTS 'Vitaly'@'localhost' IDENTIFIED BY 'YES';

DROP DATABASE IF EXISTS BOOKS_HIBERNATE;
CREATE DATABASE BOOKS_HIBERNATE;
USE BOOKS_HIBERNATE;
GRANT ALL PRIVILEGES ON BOOKS_HIBERNATE.* TO 'Vitaly'@'localhost';

FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';