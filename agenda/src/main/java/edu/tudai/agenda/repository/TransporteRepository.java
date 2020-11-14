package edu.tudai.agenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tudai.agenda.model.Transporte;

public interface TransporteRepository extends JpaRepository<Transporte, Long>{
	
	@Query("SELECT t FROM Transporte t where t.id_plan = :id_plan")
    public Optional<Transporte> findById(Long id_plan);

}
