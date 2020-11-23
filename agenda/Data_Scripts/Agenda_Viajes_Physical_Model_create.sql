
/*Viajes x realizar*/

INSERT INTO Viaje(id,nombre,destino,inicio,descripcion,Usuario_id,fin) VALUES (17,"indonecia","bolibia","2021-05-23T14:25:10.487","lalala en claromeco",16,"2021-05-23T14:25:10.487");
INSERT INTO Viaje(id,nombre,destino,inicio,descripcion,Usuario_id,fin) VALUES (15,"indonecia","bolibia","2021-05-23T14:25:10.487","lalala en claromeco",20,"2021-05-23T14:25:10.487");
INSERT INTO Viaje(id,nombre,destino,inicio,descripcion,Usuario_id,fin) VALUES (16,"indonecia","bolibia","2021-05-23T14:25:10.487","lalala en claromeco",12,"2021-05-23T14:25:10.487");

/********Planes***************/

INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(1,2,"crusero","quiero mover el bote","t","2005-05-23T14:25:10.487","2005-05-25T14:25:10.487","Buque Bus");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(2,2,"Hotel A dormir","quiero mover la cama","a","2005-05-25T14:25:10.487","2005-05-25T14:25:10.487","Hotel");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(3,2,"Escalada","quiero subir la sierra","e","2005-05-25T14:25:10.487","2005-05-25T14:25:10.487","Stalone");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(4,12,"Escalada","quiero subir la sierra","e","2021-05-25T14:25:10.487","2021-05-25T14:25:10.487","Stalone");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(5,3,"crusero","quiero mover el bote","c","2005-05-23T14:25:10.487","2005-05-25T14:25:10.487","Buque Bus");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(7,5,"colectivo","quiero mover el bote","c","2015-05-23T14:25:10.487","2015-05-26T14:25:10.487","Buque Bus");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(8,12,"Hotel A dormir","quiero mover la cama","a","2005-05-25T14:25:10.487","2005-05-25T14:25:10.487","Hotel");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(9,13,"Hotel A dormir","quiero mover la cama","a","2005-05-25T14:25:10.487","2005-05-25T14:25:10.487","Hotel");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(10,16,"Hotel A dormir","quiero mover la cama","a","2005-05-25T14:25:10.487","2005-05-25T14:25:10.487","Hotel");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(11,11,"Hotel A dormir","quiero mover la cama","a","2005-05-25T14:25:10.487","2005-05-25T14:25:10.487","Hotel");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(12,16,"Piruetas","quiero mover la cama","a","2015-05-25T14:25:10.487","2015-05-26T14:25:10.487","Aventura");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(13,13,"Piruetas","quiero mover la cama","a","2019-05-25T14:25:10.487","2019-05-26T14:25:10.487","Aventura");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(14,12,"Piruetas","quiero mover la cama","a","2020-05-25T14:25:10.487","2020-05-26T14:25:10.487","Aventura");
INSERT INTO Plan(id_plan,Viaje_id,nombre,descripcion,tipo,inicio,fin,empresa) VALUES(15,16,"Piruetas","quiero mover la cama","a","2018-05-25T14:25:10.487","2018-05-26T14:25:10.487","Aventura");


/***************Transporte****************/
INSERT INTO Transporte(nro,estacion_origen,estacion_destino,origen,destino,Plan_id_plan) VALUES(555,"Mar del plata","Puerto indonecia","indonecia","Brazil",1);
INSERT INTO Transporte(nro,estacion_origen,estacion_destino,origen,destino,Plan_id_plan) VALUES(555,"Mar del plata","Puerto indonecia","indonecia","Brazil",5);
INSERT INTO Transporte(nro,estacion_origen,estacion_destino,origen,destino,Plan_id_plan) VALUES(565,"La plata","Puerto ququen","indonecia","Brazil",5);
INSERT INTO Transporte(nro,estacion_origen,estacion_destino,origen,destino,Plan_id_plan) VALUES(565,"La plata","Puerto ququen","indonecia","Brazil",7);


/***************Alojamiento*******************/
INSERT INTO Alojamiento(direccion,localidad,Plan_id_plan) VALUES("Constitucion 1145","brazil",2);
INSERT INTO Alojamiento(direccion,localidad,Plan_id_plan) VALUES("Constitucion 1145","brazil",8);
INSERT INTO Alojamiento(direccion,localidad,Plan_id_plan) VALUES("Constitucion 1145","brazil",9);
INSERT INTO Alojamiento(direccion,localidad,Plan_id_plan) VALUES("Constitucion 1145","brazil",10);
INSERT INTO Alojamiento(direccion,localidad,Plan_id_plan) VALUES("Constitucion 1145","brazil",11);


/***************Excursion*************************/

INSERT INTO Excusion(origen,destino,localidad,Plan_id_plan) VALUES("hotel","cava encantada","chiguagua",3);
INSERT INTO Excusion(origen,destino,localidad,Plan_id_plan) VALUES("hotel","cava encantada","chiguagua",4);
INSERT INTO Excusion(origen,destino,localidad,Plan_id_plan) VALUES("hotel","cava encantada","chiguagua",12);
INSERT INTO Excusion(origen,destino,localidad,Plan_id_plan) VALUES("hotel","cava encantada","chiguagua",13);
INSERT INTO Excusion(origen,destino,localidad,Plan_id_plan) VALUES("hotel","cava encantada","chiguagua",14);
INSERT INTO Excusion(origen,destino,localidad,Plan_id_plan) VALUES("hotel","cava encantada","chiguagua",15);











