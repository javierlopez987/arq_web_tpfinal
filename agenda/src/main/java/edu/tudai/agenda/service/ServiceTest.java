package edu.tudai.agenda.service;


import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.agenda.model.Viaje;
import edu.tudai.agenda.repository.ViajeRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ServiceTest {
	
	// Servicio público. No requiere login. Está configurado en SecurityConfig
	@GetMapping("/greetings")
	public String greet() {
		return "Bienvenido al servicio de login";
	}
	
	// Servicio que requiere estar logeados (por defecto).
	@GetMapping("/loginrequired")
	public String logged() {
		return "Login required: " + SecurityContextHolder.getContext();
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/quotes")
	public String getQuote() {
		return "It's dangerous to go alone! Take this. Login info: " + SecurityContextHolder.getContext();
	}
	
}
