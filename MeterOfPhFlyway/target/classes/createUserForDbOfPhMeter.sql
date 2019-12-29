CREATE DATABASE DbForPhMeter;
CREATE USER 'userOhPhMeterApplication'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON * DbForPhMeter * TO 'userOhPhMeterApplication'@'localhost';
FLUSH PRIVILEGES;