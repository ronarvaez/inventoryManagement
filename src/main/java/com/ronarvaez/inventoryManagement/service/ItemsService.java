package com.ronarvaez.inventoryManagement.service;

import java.util.ArrayList;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;

public interface ItemsService {

	ArrayList<ItemDTO> getItems() throws Exception;

	ItemDTO addItem(ItemDTO item) throws Exception;

	ItemDTO update(int index, ItemDTO item) throws Exception;

	ItemDTO getItem(int index) throws Exception;

	ArrayList<ItemDTO> addItems(ArrayList<ItemDTO> items) throws Exception;

	ArrayList<ItemDTO> clearItems() throws Exception;

	ArrayList<ItemDTO> deleteItem(int index) throws Exception;

}
