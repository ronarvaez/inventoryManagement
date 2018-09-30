package com.ronarvaez.inventoryManagement.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;


@Component("itemsDao")
public class ItemsDAO {
	private final ArrayList<ItemDTO> items = new ArrayList<ItemDTO>();
	
	public ItemDTO add(ItemDTO item) throws Exception{
		if(this.items.add(item)) {
			return item;
		}
		throw new Exception("Add failed");
	}
	
	public ItemDTO get(int index) throws Exception{
		if(index<0 || index >= this.items.size()) {
			throw new Exception("Index not found");
		}
		return this.items.get(index);
	}

	public ArrayList<ItemDTO> getAll() throws Exception{
		return this.items;
	}

	public ItemDTO update(int index, ItemDTO item) throws Exception {
		if(index<0 || index >= this.items.size()) {
			throw new Exception("Index not found");
		}
		
		this.items.set(index, item);
		return this.items.get(index);
	}

	public ItemDTO remove(int index) throws Exception{
		return items.remove(index);
	}

	public ArrayList<ItemDTO> clear() throws Exception{
		items.clear();
		return items;
	}

}
