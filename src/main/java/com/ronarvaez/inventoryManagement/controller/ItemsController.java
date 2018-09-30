package com.ronarvaez.inventoryManagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.service.ItemsService;

@RestController
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ItemDTO> getAllItems() {
		try {
			return itemsService.getItems();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

	@RequestMapping(value = "/items", method = RequestMethod.POST)
	@ResponseBody
	public ItemDTO postItem(@RequestBody ItemDTO item) {
		try {
			return itemsService.addItem(item);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

	@RequestMapping(value = "/items/bulk", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<ItemDTO> postItemBulk(@RequestBody ArrayList<ItemDTO> items) {
		try {
			return itemsService.addItems(items);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

	@RequestMapping(value = "/items/{index}", method = RequestMethod.PATCH)
	@ResponseBody
	public ItemDTO patchItem(@PathVariable("index") int index, @RequestBody ItemDTO item) {
		try {
			return itemsService.update(index, item);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

	@RequestMapping(value = "/items/{index}", method = RequestMethod.GET)
	@ResponseBody
	public ItemDTO getItem(@PathVariable("index") int index) {
		try {
			return itemsService.getItem(index);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

	@RequestMapping(value = "/items", method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<ItemDTO> deleteAll() {
		try {
			return itemsService.clearItems();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

	@RequestMapping(value = "/items/{index}", method = RequestMethod.DELETE)
	@ResponseBody
	public ArrayList<ItemDTO> delete(@PathVariable("index") int index) {
		try {
			return itemsService.deleteItem(index);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Something went wrong");
			return null;
		}
	}

}
