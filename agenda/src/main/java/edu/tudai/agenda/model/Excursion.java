package edu.tudai.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Excursion")
@PrimaryKeyJoinColumn(name = "Plan_id_plan")
@Data
@EqualsAndHashCode(callSuper = false)
public class Excursion extends Plan {
	@Column
	private String origen;
	@Column
	private String destino;
	@Column
	private String localidad;
}
