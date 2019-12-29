CREATE TABLE IF NOT EXISTS phdata (
 id int auto_increment,
 dateOfMeasure date not null,
 timeOfMeausure date not null,
 ph double not null
);

CREATE TABLE IF NOT EXISTS action (
id int auto_increment,
typeOfAction varchar(255) not null,
isEnable boolean not null
);