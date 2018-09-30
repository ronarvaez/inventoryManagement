package com.ronarvaez.inventoryManagement.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.model.Item;
import com.ronarvaez.inventoryManagement.service.ItemsService;
import com.ronarvaez.inventoryManagement.service.StoreService;
import com.ronarvaez.inventoryManagement.util.ItemUtil;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private ItemsService itemsService;

	public ArrayList<ItemDTO> processEOD() throws Exception {
		calculateEndOfDay();
		return itemsService.getItems();
	}

	public ArrayList<ItemDTO> processEOD(int days) throws Exception {
		if(days<=0) {
			throw new Exception("Days must be more than 1");
		}
		while(days>0) {
			calculateEndOfDay();
			days--;
		}
		return itemsService.getItems();
	}
	
	private void calculateEndOfDay() throws Exception{
		ArrayList<ItemDTO> items = itemsService.getItems();
		for(int i=0; i<items.size(); i++) {
			ItemDTO degradatedItem = processDegradation(ItemUtil.fromDTO(items.get(i)));
			itemsService.update(i, degradatedItem);
		}
	}
	
	private ItemDTO processDegradation(Item item) throws Exception {
		item.degrade();
		return ItemUtil.toDTO(item);
	}

}
