package edu.tudai.usuario.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginService {

	// Servicio público. No requiere login. Está configurado en LoginConfiguration
	@GetMapping("/greetings")
	public String greet() {
		return "Bienvenido al servicio de login";
	}

	// Servicio que requiere estar logeados (por defecto).
	@GetMapping("/loginrequired")
	public String logged() {
		return "Login required: " + SecurityContextHolder.getContext();
	}

	// Servicio que requiere la autoridad de LINK
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public String logAdmin() {
		return "It's dangerous to go alone! Take this. Login info: " + SecurityContextHolder.getContext();
	}
}
