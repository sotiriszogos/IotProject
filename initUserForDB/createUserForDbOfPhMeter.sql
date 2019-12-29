-- run in mysql console: source /Users/sakes/Documents/GitHub/PhMeasure/initUserForDB/createUserForDbOfPhMeter.sql
DROP USER IF EXISTS 'userOhPhMeterApplication'@'localhost';
DROP DATABASE IF EXISTS DbForPhMeter;
CREATE DATABASE DbForPhMeter;
CREATE USER 'userOhPhMeterApplication'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON DbForPhMeter.* TO 'userOhPhMeterApplication'@'localhost';
FLUSH PRIVILEGES;