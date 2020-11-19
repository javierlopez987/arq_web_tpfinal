package edu.tudai.agenda.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Plan {

	@Id
	@Column(name = "id_plan")
	private Long idPlan;
	@Column
	private String nombre;
	@Column
	private String empresa;
	@Column
	private String descripcion;
	@Column
	private char tipo;
	@Column
	private Timestamp inicio;
	@Column
	private Timestamp fin;
	@Transient
	@JsonIgnore
	@ManyToOne
	private Viaje Viaje_id;
}
