package edu.tudai.agenda.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tudai.agenda.model.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Long>{
	
	@Query("SELECT v FROM Viaje v where v.propietario = :id_usuario and v.inicio >= :fecha")
    public List<Viaje> findByUserGteDate(Long id_usuario, Date fecha);
	
	@Query("SELECT v FROM Viaje v where v.propietario = :id_usuario and v.fin < :fecha")
    public List<Viaje> findByUserLtDate(Long id_usuario, Date fecha);
}
