package com.ronarvaez.inventoryManagement.model;

public class Sulfura extends Item {

	public Sulfura(int quality) {
		super(quality, 0, "Sulfuras", 0);
	}
	
	public Sulfura(int quality, String description) {
		super(quality, 0, description, 0);
	}
	
	public Sulfura(int quality, int sellIn, String description) {
		super(quality, 0, description, 0);
	}
	
	@Override
	public void degrade() {
	}

}
