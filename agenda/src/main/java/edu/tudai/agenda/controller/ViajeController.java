package edu.tudai.agenda.controller;

import java.util.Optional;

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

@RestController
@RequestMapping("viajes")
@Api(value = "Viajes", description = "REST SERVICE Viajes")
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
	public Optional<Viaje> getViaje(@PathVariable Long id) {
		return repository.findById(id);
	}
}
