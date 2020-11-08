-- USUARIOS
INSERT INTO usuario (id, nombre, apellido, email, documento, password)
    VALUES(1, "Pedro", "Marmol", "pmarmol@gmail.com", "40987654", "marmol");

-- VIAJES
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(1, "primer viaje", "Madrid", "2020-11-08 00:00:00", "2020-12-15 00:00:00", "Ninguna", 1);
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(2, "segundo viaje", "Lisboa", "2020-11-08 00:00:00", "2020-12-15 00:00:00", "Ninguna", 1);
INSERT INTO viaje (id, nombre, destino, inicio, fin, descripcion, Usuario_id)
    VALUES(3, "viaje antiguo", "Mendoza", "2019-11-08 00:00:00", "2019-12-15 00:00:00", "Ninguna", 1);