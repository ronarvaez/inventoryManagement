package com.ronarvaez.inventoryManagement.model;

public class Item {

	protected int quality;
	protected int sellIn;
	protected String description;
	protected final int decrementBy;

	public Item(int quality, int sellIn, String description) {
		this.quality = quality;
		this.sellIn = sellIn;
		this.description = description;
		this.decrementBy = 1;
	}

	public Item(int quality, int sellIn, String description, int decrementBy) {
		this.quality = quality;
		this.sellIn = sellIn;
		this.description = description;
		this.decrementBy = decrementBy;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDecrementBy() {
		return decrementBy;
	}

	public void degrade() {
		this.degradeQuality();
		this.sellIn--;
	}

	protected void degradeQuality() {
		if (this.quality > 0 || this.quality < 50) {
			int multiplier = 1;
			if (this.sellIn <= 0) {
				multiplier = 2;
			}
			this.quality -= this.decrementBy * multiplier;
		}

		if (this.quality < 0) {
			this.quality = 0;
		}

		if (this.quality > 50) {
			this.quality = 50;
		}
	}

}
