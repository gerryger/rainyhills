package com.ggunawan.rainyhills;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ggunawan.rainyhills.controllers.RainyHillsController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private RainyHillsController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
