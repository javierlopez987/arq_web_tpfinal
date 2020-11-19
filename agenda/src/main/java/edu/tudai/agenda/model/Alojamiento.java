package edu.tudai.agenda.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@PrimaryKeyJoinColumn(name = "Plan_id_plan")
@Data
@EqualsAndHashCode(callSuper = false)
public class Alojamiento extends Plan {
	@Column
	private String direccion;
	@Column
	private String localidad;
}
