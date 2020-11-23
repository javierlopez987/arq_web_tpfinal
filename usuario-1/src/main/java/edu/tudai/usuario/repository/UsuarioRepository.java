package edu.tudai.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tudai.usuario.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	 /**
	  * Se utiliza desde el Controller para verificar usuario
	  * @param email
	  * @return
	  */
	 @Query("SELECT u FROM Usuario u where u.email = :email")
	    public Usuario findByEmail(String email);

}
