package com.ronarvaez.inventoryManagement.model;

public class AgedBrie extends Item{

	public AgedBrie(int quality, int sellIn) {
		super(quality, sellIn, "Aged Brie", -1);
	}
	
	public AgedBrie(int quality, int sellIn, String description) {
		super(quality, sellIn, description, -1);
	}
}
