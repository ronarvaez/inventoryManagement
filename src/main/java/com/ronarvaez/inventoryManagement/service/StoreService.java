package com.ronarvaez.inventoryManagement.service;

import java.util.ArrayList;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;

public interface StoreService {

	ArrayList<ItemDTO> processEOD() throws Exception;

	ArrayList<ItemDTO> processEOD(int days) throws Exception;

}
