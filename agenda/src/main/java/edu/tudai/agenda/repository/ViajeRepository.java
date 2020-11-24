package edu.tudai.agenda.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tudai.agenda.dto.ViajesUsuarioDTO;
import edu.tudai.agenda.dto.ViajesZonaDTO;
import edu.tudai.agenda.model.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
	
	/**
	 * 
	 * @param id_usuario
	 * @param fecha
	 * @return
	 */
	@Query("SELECT v FROM Viaje v where v.propietario = :id_usuario and v.inicio >= :fecha")
    public List<Viaje> findByUserGteDate(Long id_usuario, Timestamp fecha);
	
	@Query("SELECT v FROM Viaje v where v.propietario = :id_usuario and v.fin < :fecha")
    public List<Viaje> findByUserLtDate(Long id_usuario, Timestamp fecha);
	
	/**
	 * Lista viajes por usuario entre determinadas fechas
	 * @param id_usuario
	 * @param lim_min
	 * @param lim_max
	 * @return List<Viaje>
	 */
	@Query("SELECT v FROM Viaje v where v.propietario = :id_usuario and v.inicio >= :lim_min and v.inicio <= :lim_max")
    public List<Viaje> findByUserBtDates(Long id_usuario, Timestamp lim_min, Timestamp lim_max);
	
	@Query("SELECT new edu.tudai.agenda.dto.ViajesUsuarioDTO(v.propietario, COUNT(v.propietario) AS cant_viajes) "
			+ "FROM Viaje v GROUP BY v.propietario ORDER BY cant_viajes DESC")
	public List<ViajesUsuarioDTO> selectCantViajesPorUsuario();
	
	/**
	 * Se considera cada viaje como una visita, un usuario puede viajar varias veces al mismo destino
	 * por ello la cantidad total no se determina por cantidad de usuario sino por cantidad de viajes
	 * @return
	 */
	@Query("SELECT new edu.tudai.agenda.dto.ViajesZonaDTO(v.destino, COUNT(v) AS cant_viajes) "
			+ "FROM Viaje v GROUP BY v.destino ORDER BY cant_viajes DESC")
	public List<ViajesZonaDTO> selectCantViajesPorZona();
	
}
