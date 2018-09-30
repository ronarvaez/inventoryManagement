package com.ronarvaez.inventoryManagement.dto;

import com.ronarvaez.inventoryManagement.util.ItemType;

public class ItemDTO {
	private String description;
	private int quality;
	private int sellIn;
	private ItemType type;

	public ItemDTO() {
	}

	public ItemDTO(String description, int quality, int sellIn) {
		this.description = description;
		this.quality = quality;
		this.sellIn = sellIn;
		this.type = ItemType.BASIC;
	}

	public ItemDTO(String description, int quality, int sellIn, ItemType type) {
		this.description = description;
		this.quality = quality;
		this.sellIn = sellIn;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

}
