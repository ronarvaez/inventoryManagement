package com.ronarvaez.inventoryManagement;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ronarvaez.inventoryManagement.controller.ItemsController;
import com.ronarvaez.inventoryManagement.controller.StoreController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private StoreController storeController;
	
	@Autowired
	private ItemsController itemsController;
	
	@Test
	public void contextLoads() throws Exception{
		assertThat(storeController).isNotNull();
		assertThat(itemsController).isNotNull();
	}
}
