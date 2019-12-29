--init values of tables in Application of PH Meter

INSERT INTO phdata(id,dateOfMeasure,timeOfMeasure,ph) VALUES(1,'2020-01-01','00:00:00',3.33);
INSERT INTO phdata(id,dateOfMeasure,timeOfMeasure,ph) VALUES(2,'2020-01-01','00:00:00',3.33);
INSERT INTO phdata(id,dateOfMeasure,timeOfMeasure,ph) VALUES(3,'2020-01-01','00:00:00',3.33);
INSERT INTO phdata(id,dateOfMeasure,timeOfMeasure,ph) VALUES(4,'2020-01-01','00:00:00',3.33);

INSERT INTO actionOfSystem(id,typeOfAction,isEnable) VALUES(1,'Fill mixture with water',true);
INSERT INTO actionOfSystem(id,typeOfAction,isEnable) VALUES(2,'Blend mixture',false);
INSERT INTO actionOfSystem(id,typeOfAction,isEnable) VALUES(3,'No action',true);
INSERT INTO actionOfSystem(id,typeOfAction,isEnable) VALUES(4,'Fill mixture with chemicals',false);
INSERT INTO actionOfSystem(id,typeOfAction,isEnable) VALUES(5,'Remove 400 ml from mixture', true);
