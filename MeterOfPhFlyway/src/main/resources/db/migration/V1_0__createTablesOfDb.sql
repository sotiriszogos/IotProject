CREATE TABLE IF NOT EXISTS phdata (
 id int auto_increment PRIMARY KEY,
 dateOfMeasure varchar(20),
 timeOfMeasure varchar(20),
 ph double not null
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS actionOfSystem (
id int auto_increment PRIMARY KEY,
typeOfAction varchar(255) not null,
isEnable boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;