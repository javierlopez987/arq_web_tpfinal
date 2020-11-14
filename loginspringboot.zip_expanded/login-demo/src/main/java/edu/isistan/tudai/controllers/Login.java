package edu.isistan.tudai.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class Login {

	//Servicio de login
	@PostMapping("/user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		//En el caso normal debería chequear que el usuario exista.
		String token = getJWTToken(username, pwd.equals("link"));
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
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
				.setId("knife")
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
