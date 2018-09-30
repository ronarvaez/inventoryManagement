package com.ronarvaez.inventoryManagement.repository.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ronarvaez.inventoryManagement.dao.ItemsDAO;
import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.repository.ItemsRepository;

@Repository("itemsRepository")
public class ItemsRepositoryImpl implements ItemsRepository {
	
	@Autowired
	private ItemsDAO itemsDao;
	
	public ItemDTO addItem(ItemDTO item) throws Exception{
		return itemsDao.add(item);
	}
	
	public ItemDTO getItem(int index) throws Exception{
		return itemsDao.get(index);
	}

	public ArrayList<ItemDTO> getItems() throws Exception {
		return itemsDao.getAll();
	}

	public ItemDTO updateItem(int index, ItemDTO item) throws Exception {
		return itemsDao.update(index, item);
	}

	public ArrayList<ItemDTO> clearItems() throws Exception {
		return itemsDao.clear();
	}

	public ArrayList<ItemDTO> deleteItem(int index) throws Exception {
		itemsDao.remove(index);
		return itemsDao.getAll();
	}
	
}
