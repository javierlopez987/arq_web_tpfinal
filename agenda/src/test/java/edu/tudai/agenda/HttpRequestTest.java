package edu.tudai.agenda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private static int port = 8081;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testGreeting() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greetings", String.class)).contains("Bienvenido al servicio de login");
	}
}
