package com.ronarvaez.inventoryManagement.service;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.repository.ItemsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceTest {
	
	@Autowired
	private StoreService storeService;

	@MockBean
	private ItemsRepository itemsRepository;
	
	@Test
	public void shouldCalculateEndOfDayAndReturnList() throws Exception{
		ArrayList<ItemDTO> firstReturn = new ArrayList<ItemDTO>();
		firstReturn.add(new ItemDTO("+5 Dexterity Vest", 20, 10));
		ArrayList<ItemDTO> secondReturn = new ArrayList<ItemDTO>();
		ItemDTO updatedItem = new ItemDTO("+5 Dexterity Vest", 19, 9);
		secondReturn.add(updatedItem);
		
		storeService.processEOD();
		when(itemsRepository.getItems()).thenReturn(firstReturn).thenReturn(secondReturn);
		
		verify(itemsRepository, times(2)).getItems();
	}
	
	@Test
	public void shouldCalculateMultipleEndOfDayAndReturnList() throws Exception{
		ArrayList<ItemDTO> firstReturn = new ArrayList<ItemDTO>();
		firstReturn.add(new ItemDTO("+5 Dexterity Vest", 20, 10));
		ArrayList<ItemDTO> secondReturn = new ArrayList<ItemDTO>();
		firstReturn.add(new ItemDTO("+5 Dexterity Vest", 19, 9));
		ArrayList<ItemDTO> thirdReturn = new ArrayList<ItemDTO>();
		thirdReturn.add(new ItemDTO("+5 Dexterity Vest", 18, 8));
		
		storeService.processEOD(2);
		when(itemsRepository.getItems()).thenReturn(firstReturn).thenReturn(secondReturn).thenReturn(thirdReturn);
		
		verify(itemsRepository, times(3)).getItems();
	}
	
}
