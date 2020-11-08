package edu.tudai.agenda.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column
	private Date inicio;
	@Column
	private Date fin;
	@Column
	private String descripcion;
	@Transient
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Viaje_id")
	private List<Plan> planes;
	@Column(name = "Usuario_id")
	private Long propietario;
	
}
