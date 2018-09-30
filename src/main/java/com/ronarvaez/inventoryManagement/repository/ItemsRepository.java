package com.ronarvaez.inventoryManagement.repository;

import java.util.ArrayList;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;

public interface ItemsRepository {

	ItemDTO getItem(int index) throws Exception;

	ArrayList<ItemDTO> getItems() throws Exception;

	ItemDTO addItem(ItemDTO item) throws Exception;

	ItemDTO updateItem(int index, ItemDTO item) throws Exception;

	ArrayList<ItemDTO> clearItems() throws Exception;

	ArrayList<ItemDTO> deleteItem(int index)throws Exception;

}
