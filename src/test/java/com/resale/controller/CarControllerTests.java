package com.resale.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ing.resale.controller.CarController;
import com.ing.resale.model.Car;
import com.ing.resale.service.ICarService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@WebMvcTest(controllers = CarController.class)
public class CarControllerTests {

	@MockBean
	ICarService carService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@BeforeEach
	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetListOfCars() throws UnsupportedEncodingException, Exception {

		carService = Mockito.spy(ICarService.class);
		ArrayList<Car> cars = new ArrayList<Car>();
		when(carService.getListOfCars("asc", "date_added")).thenReturn(cars);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cars").queryParam("order", "asc")
				.queryParam("property", "date_added");

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
		assertEquals(200, response.getStatus());
	}

}
