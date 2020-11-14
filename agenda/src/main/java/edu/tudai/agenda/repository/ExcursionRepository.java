package edu.tudai.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.tudai.agenda.model.Excursion;


public interface ExcursionRepository extends JpaRepository<Excursion, Long>{

}
