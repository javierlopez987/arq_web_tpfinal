Instrucciones

#Cargar los siguientes comandos para la creacion y cargado de la base de datos

CREATE database db_arq_web_tpfinal

USE db_arq_web_tpfinal

# adjuntados script de creacion de Tablas 

		Agenda_Viajes_Physical_Model_create_v4

#Adjuntado archivo de cargado de tablas

		db_insert
		
# para poder comprobar servicios crud de todas las tablas se creo una Branch "app_sintoken"
# ya que en la que tiene el token no da los permisos necesarios para la comprobacion

Los datos de usuario y pass estan preseteados para la prueba en el index

Las consultas son sobre usuari, se pudo implementar en la web los servicios mostrar Viajes Realizados y viajes Futuros