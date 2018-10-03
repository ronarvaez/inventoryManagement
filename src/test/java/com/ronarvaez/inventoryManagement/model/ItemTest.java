package com.ronarvaez.inventoryManagement.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTest {
	
	@Test
	public void shouldDegradeQualityByOneIfSellInIsPositive() {
		Item item = new Item(10, 20, "Testing Simple Item");
		Assert.isTrue(item.getQuality() == 10, "Quality should be 10");
		Assert.isTrue(item.getSellIn() == 20, "Sell In should be 20");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 9, "Quality should be degraded to 9");
		Assert.isTrue(item.getSellIn() == 19, "Sell In should be now 19");
	}
	
	@Test
	public void shouldDegradeQualityByTwoIfSellInIsZero() {
		Item item = new Item(10, 0, "Testing Simple Item");
		Assert.isTrue(item.getQuality() == 10, "Quality should be 10");
		Assert.isTrue(item.getSellIn() == 0, "Sell In should be 0");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 8, "Quality should be degraded to 8");
		Assert.isTrue(item.getSellIn() == -1, "Sell In should be now -1");
	}
	
	@Test
	public void shouldDegradeQualityByTwoIfSellInIsNegative() {
		Item item = new Item(10, -2, "Testing Simple Item");
		Assert.isTrue(item.getQuality() == 10, "Quality should be 10");
		Assert.isTrue(item.getSellIn() == -2, "Sell In should be 0");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 8, "Quality should be degraded to 8");
		Assert.isTrue(item.getSellIn() == -3, "Sell In should be now -3");
	}
	
	@Test
	public void shouldNotDegradeQualityIfIsZero() {
		Item item = new Item(0, 0, "Testing Simple Item");
		Assert.isTrue(item.getQuality() == 0, "Quality should be 0");
		Assert.isTrue(item.getSellIn() == 0, "Sell In should be 0");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 0, "Quality should be degraded to 0");
		Assert.isTrue(item.getSellIn() == -1, "Sell In should be now -1");
	}
	
	@Test
	public void shouldNotIncreaseQualityMoreThan50() {
		Item item = new Item(50, 0, "Testing Simple Item", -1);
		Assert.isTrue(item.getQuality() == 50, "Quality should be 50");
		Assert.isTrue(item.getSellIn() == 0, "Sell In should be 0");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 50, "Quality should be degraded to 50");
		Assert.isTrue(item.getSellIn() == -1, "Sell In should be now -1");
	}

}
