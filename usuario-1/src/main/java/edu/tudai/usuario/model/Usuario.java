package edu.tudai.usuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Usuario {
	@Id
	private long id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column(unique = true, nullable = false)
	private String email;
	@Column
	private int documento;
	@Column
	private String password;
	@Column
	private int rol;
}
