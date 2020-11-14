package edu.tudai.usuario.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tudai.usuario.model.Usuario;
import edu.tudai.usuario.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private final UsuarioRepository repository;
	
	public LoginController(UsuarioRepository repository) {
		this.repository = repository;
	}

	//Servicio de login
		@PostMapping("/id")
		public Usuario login(@RequestParam("id") Long id, @RequestParam("password") String pwd) {
			//En el caso normal debería chequear que el usuario exista.
			Usuario user = null;
			if(repository.userAutentication(id, pwd)) {
				String token = getJWTToken(id.toString(), true);
				user = repository.getOne(id);
				user.setToken(token);						
			};
			return user;
			
		}

		//Genero el token.
		private String getJWTToken(String username, boolean link) {
			String secretKey = "mySecretKey";
			String roles = "ROLE_USER";
			if (link) {
				roles += ",LINK";
			}
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList(roles);
			
			String token = Jwts
					.builder()
					.setId(username)
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();

			return "Bearer " + token;
		}
}
