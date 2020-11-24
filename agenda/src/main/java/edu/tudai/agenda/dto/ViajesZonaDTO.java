package edu.tudai.agenda.dto;

import lombok.Data;

@Data
public class ViajesZonaDTO {

	private String zona;
	private long cant_viajes;
	
	public ViajesZonaDTO(String zona, long cant_viajes) {
		super();
		this.zona = zona;
		this.cant_viajes = cant_viajes;
	}
	
}
