package edu.tudai.agenda.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@PrimaryKeyJoinColumn(name = "Plan_id_plan")
@Data
@EqualsAndHashCode(callSuper = false)
public class Alojamiento extends Plan {
	
	private Long id;
	private Date entrada;
	private Date salida;
	private String direccion;
	private String localidad;
}
