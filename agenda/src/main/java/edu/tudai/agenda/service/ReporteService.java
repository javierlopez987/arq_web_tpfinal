package edu.tudai.agenda.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

public class ReporteService {

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/quotes")
	public String getQuote() {
		return "It's dangerous to go alone! Take this. Login info: " + SecurityContextHolder.getContext();
	}
}
