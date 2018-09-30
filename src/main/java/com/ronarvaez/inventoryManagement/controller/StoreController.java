package com.ronarvaez.inventoryManagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.service.StoreService;

@RestController
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value="/processEOD", method= RequestMethod.GET)
	@ResponseBody
	public ArrayList<ItemDTO> processEOD() {
		try {
			return storeService.processEOD();
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}
	
	@RequestMapping(value="/processEOD/{days}", method= RequestMethod.GET)
	@ResponseBody
	public ArrayList<ItemDTO> processMultipleEOD(@PathVariable("days") int days) {
		try {
			return storeService.processEOD(days);
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}


}
