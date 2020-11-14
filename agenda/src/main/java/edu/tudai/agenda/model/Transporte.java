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
public class Transporte extends Plan {
	@Column
	private String empresa;
	@Column
	private int nro;
	@Column
	private String terminalOrig;
	@Column
	private String terminalDest;
	@Column
	private String origen;
	@Column
	private String destino;
	@Column
	private Date salida;
	@Column
	private Date llegada;
}
