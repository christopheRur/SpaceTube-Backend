package com.codelab.spaceTube;

import com.codelab.spaceTube.Controller.SpaceTubeController;
import com.codelab.spaceTube.services.SpaceTubeServiceImpl;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SpaceTubeApplicationTests {
	@Mock
	private SpaceTubeServiceImpl spaceTubeService;
	@InjectMocks
	private SpaceTubeController controller;

	@Test
	void contextLoads() {
	}

	@Test
	public void testBadRequestLocalStatus() throws IOException {

		Mockito.when(spaceTubeService.retrieveNasaData()).thenReturn(new JsonObject());
		ResponseEntity<?> response = controller.getNasaDetails();
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}


}
