package com.ronarvaez.inventoryManagement.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.repository.ItemsRepository;
import com.ronarvaez.inventoryManagement.service.ItemsService;
import com.ronarvaez.inventoryManagement.util.ItemUtil;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsRepository itemsRepository;
	
	public ArrayList<ItemDTO> getItems() throws Exception {
		return itemsRepository.getItems();
	}

	public ItemDTO addItem(ItemDTO item) throws Exception {
		return itemsRepository.addItem(ItemUtil.verifyType(item));
	}

	public ItemDTO update(int index, ItemDTO item) throws Exception {
		return itemsRepository.updateItem(index,ItemUtil.verifyType(item));
	}

	public ItemDTO getItem(int index) throws Exception {
		return itemsRepository.getItem(index);
	}

	public ArrayList<ItemDTO> addItems(ArrayList<ItemDTO> items) throws Exception {
		for (ItemDTO item : items) {
			itemsRepository.addItem(ItemUtil.verifyType(item));
		}
		
		return itemsRepository.getItems();
	}

	public ArrayList<ItemDTO> clearItems() throws Exception {
		return itemsRepository.clearItems();
	}

	public ArrayList<ItemDTO> deleteItem(int index) throws Exception {
		return itemsRepository.deleteItem(index);
	}

	
	
}
