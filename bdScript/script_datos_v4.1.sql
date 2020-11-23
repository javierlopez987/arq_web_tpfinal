-- USUARIOS
INSERT INTO usuario (id, nombre, apellido, email, documento, password, rol)
    VALUES(1, "Pablo", "Marmol", "pmarmol@gmail.com", "4987654", "81DC9BDB52D04DC20036DBD8313ED055", 1);
INSERT INTO usuario (id, nombre, apellido, email, documento, password, rol)
    VALUES(2, "Pedro", "Picapiedra", "ppicapiedra@gmail.com", "4102358", "81DC9BDB52D04DC20036DBD8313ED055", 0);
INSERT INTO usuario (id, nombre, apellido, email, documento, password, rol)
    VALUES(3, "Vilma", "Picapiedra", "vpicapiedra@gmail.com", "4201897", "81DC9BDB52D04DC20036DBD8313ED055", 0);
INSERT INTO usuario (id, nombre, apellido, email, documento, password, rol)
    VALUES(4, "Betty", "Marmol", "bmarmol@gmail.com", "4453127", "81DC9BDB52D04DC20036DBD8313ED055", 0);

-- VIAJES
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(1, "Viaje de aniversario", "Madrid", "2017-11-08 00:00:00", "2017-12-15 00:00:00", "Ninguna", 1);
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(2, "Viaje de bodas", "Lisboa", "2018-11-08 00:00:00", "2018-12-15 00:00:00", "Ninguna", 1);
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(3, "Viaje de placer", "Mendoza", "2019-11-08 00:00:00", "2019-12-15 00:00:00", "Ninguna", 1);

-- PLANES
INSERT INTO plan (id_plan, nombre, descripcion, tipo, inicio, fin, empresa, Viaje_id)
    VALUES(1, "Vuelo de ida", "Vuelo de ida a Mendoza", "T", "2019-11-08 20:00:00", "2019-11-09 02:00:00", "Aerolineas Argentinas", 3);
INSERT INTO plan (id_plan, nombre, descripcion, tipo, inicio, fin, empresa, Viaje_id)
    VALUES(2, "Vuelo de vuelta", "Vuelo de vuelta de Mendoza", "T", "2019-12-15 23:00:00", "2019-12-16 04:00:00", "Aerolineas Argentinas", 3);
INSERT INTO plan (id_plan, nombre, descripcion, tipo, inicio, fin, empresa, Viaje_id)
    VALUES(3, "Hotel Mendoza", "Vuelo de ida a Mendoza", "T", "2019-11-08 20:00:00", "2019-11-09 02:00:00", "Aerolineas Argentinas", 3);
INSERT INTO plan (id_plan, nombre, descripcion, tipo, inicio, fin, empresa, Viaje_id)
    VALUES(4, "Vuelo de vuelta", "Vuelo de vuelta de Mendoza", "T", "2019-12-15 23:00:00", "2019-12-16 04:00:00", "Aerolineas Argentinas", 3);
	
-- TRANSPORTE
INSERT INTO transporte (nro, estacion_origen, estacion_destino, origen, destino, Plan_id_plan)
    VALUES(123456, "Aeroparque", "Mendoza Aeropuerto", "Buenos Aires", "Mendoza", 1);
INSERT INTO transporte (nro, estacion_origen, estacion_destino, origen, destino, Plan_id_plan)
    VALUES(123456, "Aeroparque", "Mendoza Aeropuerto", "Buenos Aires", "Mendoza", 2);