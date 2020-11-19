package edu.tudai.agenda.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
public class Viaje {
	
	@Id
	private Long id;
	@Column
	private String nombre;
	@Column
	private String destino;
	@ApiModelProperty(value = "Fecha de inicio del viaje", required = true)
	@Column(nullable = false)
	private Timestamp inicio;
	@ApiModelProperty(value = "Fecha de finalización del viaje", required = true)
	@Column(nullable = false)
	private Timestamp fin;
	@Column
	private String descripcion;
	@Transient
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Viaje_id")
	private List<Plan> planes;
	@Column(name = "Usuario_id")
	private Long propietario;
	
}
