package edu.tudai.agenda.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.agenda.model.Viaje;
import edu.tudai.agenda.repository.ViajeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("viajes")
@Api(value = "ViajeController", description = "REST API Viajes")
public class ViajeController {
	
	@Autowired
	private final ViajeRepository repository;
	
	public ViajeController(ViajeRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/")
	public Viaje newViaje(@RequestBody Viaje v) {
		return repository.save(v);
	}
	
	@PutMapping("/{id}")
	public Viaje replaceViaje(@RequestBody Viaje newViaje, @PathVariable Long id) {
		return repository.findById(id).map(viaje -> {
			viaje = newViaje;
			return repository.save(viaje);
		}).orElseGet(() -> {
			return repository.save(newViaje);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteViaje(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Viaje getViaje(@PathVariable Long id) {
		return repository.getOne(id);
	}
	
	
	/*
	 * SECCION SERVICIOS ESPECIALES
	 */
	@ApiOperation(value = "Obtiene una lista de viajes futuros de un determinado usuario", response = Iterable.class, tags = "Proximos Viajes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de viajes futuros agendados"),
			@ApiResponse(code = 401, message = "No autorizado para acceder al recurso"),
			@ApiResponse(code = 403, message = "Recurso prohibido"),
			@ApiResponse(code = 404, message = "No posee viajes futuros agendados")})
	@GetMapping("proximos/usuario/{id}")
	public Iterable<Viaje> getViajesProximos(@PathVariable Long id) {
		
		return repository.findByUserGteDate(id, Date.valueOf(LocalDate.now()));
	}
	
	@GetMapping("realizados/usuario/{id}")
	public Iterable<Viaje> getViajesRealizados(@PathVariable Long id) {
		
		return repository.findByUserLtDate(id, Date.valueOf(LocalDate.now()));
	}
}
