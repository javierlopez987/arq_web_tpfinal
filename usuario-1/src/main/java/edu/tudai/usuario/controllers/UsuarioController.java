package edu.tudai.usuario.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.usuario.model.Usuario;
import edu.tudai.usuario.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("usuarios")
@Api(value = "Usuarios", description = "REST SERVICE Usuarios")
public class UsuarioController {

	@Qualifier("usuarioRepository")
	@Autowired
	private final UsuarioRepository repository;
	
	public UsuarioController(@Qualifier("usuarioRepository") UsuarioRepository repository) {
		this.repository = repository;
	}
	
	@ApiOperation(value = "[Administrador] Listado de usuarios", tags = "Usuarios")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping
	public Iterable<Usuario> getUsuarios() {
		return repository.findAll();
	}
	
	@ApiOperation(value = "[Administrador] Obtiene el usuario cuyo id se pasa por parámetro", tags = "Usuarios")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public Optional<Usuario> one(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@ApiOperation(value = "Registra un nuevo usuario", tags = "Usuarios")
	@PostMapping
	public Usuario newUsuario(@RequestBody Usuario u) {
		MessageDigest md;
		String hash;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(u.getPassword().getBytes());
			byte[] digest = md.digest();
			hash = DatatypeConverter
				      .printHexBinary(digest).toUpperCase();
			u.setPassword(hash);
			return repository.save(u);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@ApiOperation(value = "[Administrador] Borra el usuario cuyo id se pasa por parámetro", tags = "Usuarios")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@ApiOperation(value = "Cambia la contraseña del usuario loggeado", tags = "Usuarios")
	@PutMapping("/password")
	void replacePassword(@RequestBody String password) {
		Long id = Long.parseLong((String) SecurityContextHolder.getContext().getAuthentication().getDetails());
		MessageDigest md;
		String hash;
		Usuario user = repository.findById(id).get();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			hash = DatatypeConverter
				      .printHexBinary(digest).toUpperCase();
			user.setPassword(hash);
			repository.save(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
}
