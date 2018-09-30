package com.ronarvaez.inventoryManagement.model;

public class ConcertBackstagePass extends Item {

	public ConcertBackstagePass(int quality, int sellIn) {
		super(quality, sellIn, "Concert Backstage Pass", -1);
	}
	
	public ConcertBackstagePass(int quality, int sellIn, String description) {
		super(quality, sellIn, description, -1);
	}

	@Override
	protected void degradeQuality() {
		if (quality > 0) {
			int multiplier = 1;
			if (this.sellIn > 0) {
				if (this.sellIn <= 10) {
					multiplier = 2;
				}
				this.quality -= multiplier * this.decrementBy;
			} else {
				this.quality = 0;
			}
		}
	}
}
