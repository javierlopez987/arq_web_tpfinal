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

import edu.tudai.agenda.model.Alojamiento;
import edu.tudai.agenda.repository.AlojamientoRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("alojamientos")
@Api(value = "Alojamientos", description = "REST SERVICE Alojamientos")
public class AlojamientoController {

	@Autowired
	private final AlojamientoRepository repository;
	
	public AlojamientoController(AlojamientoRepository repository) {
		this.repository = repository;
	}
	
	/*
	 * ***********CRUD*************
	 * */

	@PostMapping("/")
	public Alojamiento newAlojamiento(@RequestBody Alojamiento a) {
		return repository.save(a);
	}
	
	@PutMapping("/{id}")
	public Alojamiento replaceAlojamiento(@RequestBody Alojamiento newAlojamiento, @PathVariable Long id) {
		return repository.findById(id).map(alojamiento -> {
			alojamiento = newAlojamiento;
			return repository.save(alojamiento);
		}).orElseGet(() -> {
			return repository.save(newAlojamiento);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteAlojamiento(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Alojamiento> getAlojamiento(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	/*
	 * SERVICIOS ESPECIALES/
	 */
}
