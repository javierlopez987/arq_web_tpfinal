-- USUARIOS
INSERT INTO usuario (id, nombre, apellido, email, documento, password, rol)
    VALUES(1, "Pedro", "Marmol", "pmarmol@gmail.com", "40987654", "marmol", 1);

-- VIAJES
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(1, "primer viaje", "Madrid", "2020-11-08 00:00:00", "2020-12-15 00:00:00", "Ninguna", 1);
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(2, "segundo viaje", "Lisboa", "2020-11-08 00:00:00", "2020-12-15 00:00:00", "Ninguna", 1);
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(3, "viaje antiguo", "Mendoza", "2019-11-08 00:00:00", "2019-12-15 00:00:00", "Ninguna", 1);

-- PLANES
INSERT INTO plan (id_plan, nombre, descripcion, tipo, Viaje_id)
    VALUES(1, "Vuelo de ida", "Vuelo de ida a Mendoza", "T", 3);
	
-- TRANSPORTE
INSERT INTO transporte (empresa, nro, estacion_origen, estacion_destino, origen, destino, salida, llegada, Plan_id_plan)
    VALUES("Aerolineas Argentinas", 123456, "Aeroparque", "Mendoza Aeropuerto", "Buenos Aires", "Mendoza", "2019-11-08 00:00:00", "2019-11-09 00:00:00", 1);