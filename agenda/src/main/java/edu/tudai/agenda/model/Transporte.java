package edu.tudai.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "Transporte")
@PrimaryKeyJoinColumn(name = "Plan_id_plan")
@Data
@EqualsAndHashCode(callSuper = false)
public class Transporte extends Plan {
	@Column
	private String empresa;
	@Column
	private int nro;
	@Column 
	private String estacion_origen;
	@Column
	private String estacion_destino;
	@Column
	private String origen;
	@Column
	private String destino;
}
