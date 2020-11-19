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
@RequestMapping("reportes")
public class ReporteService {
	
	@Autowired
	private final ViajeRepository repository;
	
	public ReporteService(ViajeRepository repository) {
		this.repository = repository;
	}

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
	
	/*
	 * SECCION SERVICIOS ESPECIALES
	 */
	@ApiOperation(value = "Obtiene una lista de viajes futuros de un determinado usuario", response = Iterable.class, tags = "Reportes de Viajes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de viajes futuros agendados"),
			@ApiResponse(code = 401, message = "No autorizado para acceder al recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "No posee viajes futuros agendados")})
	@GetMapping("viajes/proximos")
	public Iterable<Viaje> getViajesProximos() {
		Long id = Long.parseLong((String) SecurityContextHolder.getContext().getAuthentication().getDetails());
		return repository.findByUserGteDate(id, Date.valueOf(LocalDate.now()));
	}
	
	@ApiOperation(value = "Obtiene una lista de viajes realizados de un determinado usuario", response = Iterable.class, tags = "Reportes de Viajes")
	@GetMapping("viajes/realizados")
	public Iterable<Viaje> getViajesRealizados() {
		Long id = Long.parseLong((String) SecurityContextHolder.getContext().getAuthentication().getDetails());
		return repository.findByUserLtDate(id, Date.valueOf(LocalDate.now()));
	}
}
