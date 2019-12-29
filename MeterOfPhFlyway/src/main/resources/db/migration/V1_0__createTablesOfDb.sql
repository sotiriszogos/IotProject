CREATE TABLE IF NOT EXISTS phdata (
 id int auto_increment PRIMARY KEY,
 dateOfMeasure date not null,
 timeOfMeausure date not null,
 ph double not null
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS actionOfSystem (
id int auto_increment PRIMARY KEY,
typeOfAction varchar(255) not null,
isEnable boolean not null
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;