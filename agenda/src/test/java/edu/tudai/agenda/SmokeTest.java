package edu.tudai.agenda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.tudai.agenda.controller.ViajeController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private ViajeController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
