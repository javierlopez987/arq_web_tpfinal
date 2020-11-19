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

import edu.tudai.agenda.model.Excursion;
import edu.tudai.agenda.repository.ExcursionRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("excursiones")
@Api(value = "Excursiones", description = "REST SERVICE Excursiones")
public class ExcursionController {
	
	@Autowired
	private final ExcursionRepository repository;

	public ExcursionController(ExcursionRepository repository) {
		super();
		this.repository = repository;
	}

	/*
	 * ********CRUD
	 * */
	
	@PostMapping("/")
	public Excursion newExcursion(@RequestBody Excursion e) {
		return repository.save(e);
	}
	
	@PutMapping("/{id}")
	public Excursion replaceExcursion(@RequestBody Excursion newExcursion, @PathVariable Long id) {
		return repository.findById(id).map(excursion -> {
			excursion = newExcursion;
			return repository.save(excursion);
		}).orElseGet(() -> {
			return repository.save(newExcursion);
		});
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteExcursion(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Excursion> getExcursion(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	/*
	 * SECCION SERVICIOS ESPECIALES
	 * */
	
}

