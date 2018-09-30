package com.ronarvaez.inventoryManagement.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ronarvaez.inventoryManagement.service.StoreService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoreControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private StoreService storeService;
	
	@Test
	public void shouldProcessOneDay() throws Exception {
		this.mockMvc.perform(get("/processEOD")).andExpect(status().isOk());
		verify(storeService, times(1)).processEOD();
	}
	
	@Test
	public void shouldProcessMultipleDays() throws Exception {
		this.mockMvc.perform(get("/processEOD/10")).andExpect(status().isOk());
		verify(storeService, times(0)).processEOD();
		verify(storeService, times(1)).processEOD(10);
	}
}
