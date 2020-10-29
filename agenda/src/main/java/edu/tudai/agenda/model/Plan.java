package edu.tudai.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public abstract class Plan {

	@Id
	private Long idPlan;
	@Column
	private String nombre;
	@Column
	private char tipo;
}
