-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-10-29 20:39:29.216

-- tables
-- Table: Alojamiento
CREATE TABLE Alojamiento (
    entrada timestamp NOT NULL,
    salida timestamp NOT NULL,
    direccion varchar(50) NOT NULL,
    localidad varchar(50) NOT NULL,
    Plan_id_plan int NOT NULL,
    CONSTRAINT Alojamiento_pk PRIMARY KEY (Plan_id_plan)
);

-- Table: Excursion
CREATE TABLE Excursion (
    origen varchar(30) NOT NULL,
    destino varchar(30) NOT NULL,
    comienzo timestamp NOT NULL,
    finalizacion timestamp NOT NULL,
    Plan_id_plan int NOT NULL,
    CONSTRAINT Excursion_pk PRIMARY KEY (Plan_id_plan)
);

-- Table: Plan
CREATE TABLE Plan (
    id_plan int NOT NULL,
    nombre varchar(30) NOT NULL,
    descripcion varchar(100) NOT NULL,
    tipo char(1) NOT NULL,
    Viaje_id int NOT NULL,
    CONSTRAINT Plan_pk PRIMARY KEY (id_plan)
);

-- Table: Transporte
CREATE TABLE Transporte (
    empresa varchar(30) NOT NULL,
    nro int NOT NULL,
    terminalOrigen varchar(30) NOT NULL,
    terminalDestino varchar(30) NOT NULL,
    origen varchar(50) NOT NULL,
    destino varchar(30) NOT NULL,
    salida timestamp NOT NULL,
    llegada timestamp NOT NULL,
    Plan_id_plan int NOT NULL,
    CONSTRAINT Transporte_pk PRIMARY KEY (Plan_id_plan)
);

-- Table: Usuario
CREATE TABLE Usuario (
    id int NOT NULL,
    nombre varchar(30) NOT NULL,
    apellido varchar(30) NOT NULL,
    email varchar(30) NOT NULL,
    documento int NOT NULL,
    password varchar(10) NOT NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (id)
);

-- Table: Viaje
CREATE TABLE Viaje (
    id int NOT NULL,
    nombre varchar(100) NOT NULL,
    destino varchar(30) NOT NULL,
    inicio timestamp NOT NULL,
    fin timestamp NOT NULL,
    descripcion varchar(100) NOT NULL,
    Usuario_id Integer NOT NULL,
    CONSTRAINT Viaje_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Alojamiento_Plan (table: Alojamiento)
ALTER TABLE Alojamiento ADD CONSTRAINT Alojamiento_Plan FOREIGN KEY Alojamiento_Plan (Plan_id_plan)
    REFERENCES Plan (id_plan);

-- Reference: Excursion_Plan (table: Excursion)
ALTER TABLE Excursion ADD CONSTRAINT Excursion_Plan FOREIGN KEY Excursion_Plan (Plan_id_plan)
    REFERENCES Plan (id_plan);

-- Reference: Plan_Viaje (table: Plan)
ALTER TABLE Plan ADD CONSTRAINT Plan_Viaje FOREIGN KEY Plan_Viaje (Viaje_id)
    REFERENCES Viaje (id);

-- Reference: Transporte_Plan (table: Transporte)
ALTER TABLE Transporte ADD CONSTRAINT Transporte_Plan FOREIGN KEY Transporte_Plan (Plan_id_plan)
    REFERENCES Plan (id_plan);

-- Reference: Viaje_Usuario (table: Viaje)
ALTER TABLE Viaje ADD CONSTRAINT Viaje_Usuario FOREIGN KEY Viaje_Usuario (Usuario_id)
    REFERENCES Usuario (id);

-- End of file.