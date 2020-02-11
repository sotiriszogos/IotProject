-- run in mysql console: source /Users/sakes/Documents/GitHub/PhMeasure/initUserForDB/createUserForDbOfPhMeter.sql
DROP USER IF EXISTS 'userOfPhMeterApplication'@'localhost';
DROP DATABASE IF EXISTS DbForPhMeter;
CREATE DATABASE DbForPhMeter;
CREATE USER 'userOfPhMeterApplication'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON DbForPhMeter.* TO 'userOfPhMeterApplication'@'localhost';
FLUSH PRIVILEGES;  