package edu.tudai.agenda.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Viaje {
	
	@Id
	private Long idViaje;
	@Column
	private String nombre;
	@Column
	private String destino;
	@Column
	private Date inicio;
	@Column
	private Date fin;
	@Column
	private String descripcion;
	
	private Plan plan;
	
}
