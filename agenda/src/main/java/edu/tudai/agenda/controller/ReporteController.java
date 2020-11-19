package edu.tudai.agenda.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ReporteController {

	@Autowired
	private final ViajeRepository repository;

	public ReporteController(ViajeRepository repository) {
		this.repository = repository;
	}
	
	@ApiOperation(value = "Obtiene una lista de viajes futuros de un determinado usuario", response = Iterable.class, tags = "Reportes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de viajes futuros agendados"),
			@ApiResponse(code = 401, message = "No autorizado para acceder al recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "No posee viajes futuros agendados")})
	@GetMapping("proximos/usuario/{id}")
	public Iterable<Viaje> getViajesProximos(@PathVariable Long id) {
		
		return repository.findByUserGteDate(id, Timestamp.valueOf(LocalDateTime.now()));
	}
	
	@ApiOperation(value = "Obtiene una lista de viajes realizados de un determinado usuario", response = Iterable.class, tags = "Reportes")
	@GetMapping("realizados/usuario/{id}")
	public Iterable<Viaje> getViajesRealizados(@PathVariable Long id) {
		
		return repository.findByUserLtDate(id, Timestamp.valueOf(LocalDateTime.now()));
	}
}
