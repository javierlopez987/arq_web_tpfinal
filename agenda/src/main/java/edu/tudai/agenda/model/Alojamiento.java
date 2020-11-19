package edu.tudai.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Alojamiento")
@PrimaryKeyJoinColumn(name = "Plan_id_plan")
@Data
@EqualsAndHashCode(callSuper = false)
public class Alojamiento extends Plan {
	@Column
	private String direccion;
	@Column
	private String localidad;
}
