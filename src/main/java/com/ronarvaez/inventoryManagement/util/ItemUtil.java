package com.ronarvaez.inventoryManagement.util;

import com.ronarvaez.inventoryManagement.dto.ItemDTO;
import com.ronarvaez.inventoryManagement.model.AgedBrie;
import com.ronarvaez.inventoryManagement.model.ConcertBackstagePass;
import com.ronarvaez.inventoryManagement.model.Item;
import com.ronarvaez.inventoryManagement.model.Sulfura;

public class ItemUtil {

	public static Item fromDTO(ItemDTO dto) {
		switch (dto.getType()) {
		case AGED_BRIE:
			return new AgedBrie(dto.getQuality(), dto.getSellIn(), dto.getDescription());
		case SULFURA:
			return new Sulfura(dto.getQuality(), dto.getSellIn(), dto.getDescription());
		case CONCERT_PASS:
			return new ConcertBackstagePass(dto.getQuality(), dto.getSellIn(), dto.getDescription());
		case BASIC:
			return new Item(dto.getQuality(), dto.getSellIn(), dto.getDescription());
		default:
			return new Item(dto.getQuality(), dto.getSellIn(), dto.getDescription());
		}
	}

	public static ItemDTO toDTO(Item item) {
		ItemType type;
		if (item instanceof AgedBrie) {
			type = ItemType.AGED_BRIE;
		} else if (item instanceof Sulfura) {
			type = ItemType.SULFURA;
		} else if (item instanceof ConcertBackstagePass) {
			type = ItemType.CONCERT_PASS;
		} else {
			type = ItemType.BASIC;
		}
		
		return new ItemDTO(item.getDescription(), item.getQuality(), item.getSellIn(),type);
	}

	public static ItemDTO verifyType(ItemDTO item) {
		if(item.getType() == null) {
			item.setType(ItemType.BASIC);
		}
		return item;
	}
}
