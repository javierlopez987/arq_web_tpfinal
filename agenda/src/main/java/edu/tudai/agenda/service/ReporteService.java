package edu.tudai.agenda.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.agenda.model.Viaje;
import edu.tudai.agenda.repository.ViajeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("reportes")
@Api(value = "Reportes", description = "REST SERVICE Reportes")
public class ReporteService {

	@Autowired
	private final ViajeRepository repository;

	public ReporteService(ViajeRepository repository) {
		this.repository = repository;
	}
	
	@ApiOperation(value = "Obtiene una lista de viajes futuros del usuario loggeado", response = Iterable.class, tags = "Reportes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de viajes futuros agendados"),
			@ApiResponse(code = 401, message = "No autorizado para acceder al recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "No posee viajes futuros agendados")})
	@GetMapping("viajes/proximos")
	public Iterable<Viaje> getViajesProximos() {
		Long id = Long.parseLong((String) SecurityContextHolder.getContext().getAuthentication().getDetails());
		return repository.findByUserGteDate(id, Timestamp.valueOf(LocalDateTime.now()));
	}
	
	@CrossOrigin
	@ApiOperation(value = "Obtiene una lista de viajes realizados del usuario loggeado", response = Iterable.class, tags = "Reportes")
	@GetMapping("viajes/realizados")
	public Iterable<Viaje> getViajesRealizados() {
		Long id = Long.parseLong((String) SecurityContextHolder.getContext().getAuthentication().getDetails());
		return repository.findByUserLtDate(id, Timestamp.valueOf(LocalDateTime.now()));
	}
	
	@ApiOperation(value = "ROLE_ADMIN Required - Obtiene una lista de viajes futuros de un determinado usuario", response = Iterable.class, tags = "Reportes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de viajes futuros agendados"),
			@ApiResponse(code = 401, message = "No autorizado para acceder al recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "No posee viajes futuros agendados")})
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("viajes/proximos/usuario/{id}")
	public Iterable<Viaje> getViajesProximosPorUsuario(@PathVariable Long id) {
		return repository.findByUserGteDate(id, Timestamp.valueOf(LocalDateTime.now()));
	}
	
	@ApiOperation(value = "ROLE_ADMIN Required - Obtiene una lista de viajes realizados de un determinado usuario", response = Iterable.class, tags = "Reportes")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("viajes/realizados/usuario/{id}")
	public Iterable<Viaje> getViajesRealizadosPorUsuario(@PathVariable Long id) {
		return repository.findByUserLtDate(id, Timestamp.valueOf(LocalDateTime.now()));
	}
}
