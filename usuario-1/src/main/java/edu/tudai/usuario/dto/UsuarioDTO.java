package edu.tudai.usuario.dto;

import edu.tudai.usuario.model.Usuario;
import lombok.Data;

/**
 * Clase DTO para información del usuario
 * durante la duración del token que no se persistirá
 */
@Data
public class UsuarioDTO {
	
	private String nombre;
	private String apellido;
	private String email;
	private int documento;
	private String token;
	
	public UsuarioDTO(Usuario user) {
		this.nombre = user.getNombre();
		this.apellido = user.getApellido();
		this.email = user.getEmail();
		this.documento = user.getDocumento();
	}
}
