package edu.tudai.agenda.dto;

import lombok.Data;

@Data
public class UsuarioViajesDTO {

	private long id_usuario;
	private long cant_viajes;
	
	public UsuarioViajesDTO(long id_usuario, long cant_viajes) {
		super();
		this.id_usuario = id_usuario;
		this.cant_viajes = cant_viajes;
	}
	
}
