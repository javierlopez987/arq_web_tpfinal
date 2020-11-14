package edu.tudai.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.agenda.model.Transporte;
import edu.tudai.agenda.repository.TransporteRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("transportes")
@Api(value = "TransporteController", description = "REST API Transporte")
public class TransporteController {
	
	@Autowired
	private final TransporteRepository repository;
	
	public TransporteController(TransporteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/")
	public Transporte newTransporte(@RequestBody Transporte t) {
		return repository.save(t);
	}
	
	@PutMapping("/{id}")
	public Transporte replaceTransporte(@RequestBody Transporte newTransporte, @PathVariable Long id) {
		return repository.findById(id).map(transporte -> {
			transporte = newTransporte;
			return repository.save(transporte);
		}).orElseGet(() -> {
			return repository.save(newTransporte);
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteTransporte(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public void getTransporte(@PathVariable Long id) {
		repository.getOne(id);
	}
	
	
	
	/*
	 *SERVICIOS ESPECIALES
	 */
	
	
}
