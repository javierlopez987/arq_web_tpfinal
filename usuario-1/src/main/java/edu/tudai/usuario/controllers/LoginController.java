package edu.tudai.usuario.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.usuario.dto.UsuarioDTO;
import edu.tudai.usuario.model.Usuario;
import edu.tudai.usuario.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class LoginController {
	
	private final int ROLE_ADMIN = 1;
	@Autowired
	private final UsuarioRepository repository;

	public LoginController(UsuarioRepository repository) {
		this.repository = repository;
	}

	// Servicio de login
	@PostMapping("user")
	public UsuarioDTO login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
		// En el caso normal debería chequear que el usuario exista.
		Usuario user = repository.findByEmail(email);
		UsuarioDTO userInfo = null;
		if(user != null) {
			userInfo = new UsuarioDTO(user);
			if(checkPassword(pwd, user.getPassword())) {
				String token = getJWTToken(user);				
				userInfo.setToken(token);
			}
		}
		return userInfo;

	}

	private boolean checkPassword(String pwdExpected, String pwdStored) {
		MessageDigest md;
		String hash;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(pwdExpected.getBytes());
			byte[] digest = md.digest();
			hash = DatatypeConverter
				      .printHexBinary(digest).toUpperCase();
			return pwdStored.equals(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// Genero el token.
	private String getJWTToken(Usuario user) {
		String secretKey = "mySecretKey";
		String roles;
		switch (user.getRol()) {
		case ROLE_ADMIN:
			roles = "ROLE_ADMIN";
			break;
		default:
			roles = "ROLE_USER";
			break;
		}
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

		String token = Jwts.builder().setId(Long.toString(user.getId())).setSubject(user.getEmail())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
