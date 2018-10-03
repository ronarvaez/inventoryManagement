package com.ronarvaez.inventoryManagement.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgedBrieTest {
	
	@Test
	public void shouldIncreaseQualityByOneIfSellInIsPositive() {
		AgedBrie agedBrie = new AgedBrie(10, 1);
		Assert.isTrue(agedBrie.getQuality() == 10, "Quality should be 10");
		Assert.isTrue(agedBrie.getSellIn() == 1, "Sell In should be 0");
		agedBrie.degrade();	
		Assert.isTrue(agedBrie.getQuality() == 11, "Quality sho1uld be degraded to 8");
		Assert.isTrue(agedBrie.getSellIn() == 0, "Sell In should be now -1");
	}
	
	@Test
	public void shouldIncreaseQualityByTwoIfSellInIsZero() {
		AgedBrie agedBrie = new AgedBrie(10, 0);
		Assert.isTrue(agedBrie.getQuality() == 10, "Quality should be 10");
		Assert.isTrue(agedBrie.getSellIn() == 0, "Sell In should be 0");
		agedBrie.degrade();	
		Assert.isTrue(agedBrie.getQuality() == 12, "Quality sho1uld be degraded to 8");
		Assert.isTrue(agedBrie.getSellIn() == -1, "Sell In should be now -1");
	}
	
	@Test
	public void shouldIncreaseQualityByTwoIfSellInIsNegative() {
		AgedBrie agedBrie = new AgedBrie(0, -1);
		Assert.isTrue(agedBrie.getQuality() == 0, "Quality should be 0");
		Assert.isTrue(agedBrie.getSellIn() == -1, "Sell In should be -1");
		agedBrie.degrade();	
		Assert.isTrue(agedBrie.getQuality() == 2, "Quality should be degraded to 2");
		Assert.isTrue(agedBrie.getSellIn() == -2, "Sell In should be now -2");
	}
	
	@Test
	public void shouldNotIncreaseQualityMoreThan50() {
		AgedBrie agedBrie = new AgedBrie(50, 0);
		Assert.isTrue(agedBrie.getQuality() == 50, "Quality should be 50");
		Assert.isTrue(agedBrie.getSellIn() == 0, "Sell In should be 0");
		agedBrie.degrade();	
		Assert.isTrue(agedBrie.getQuality() == 50, "Quality should be degraded to 50");
		Assert.isTrue(agedBrie.getSellIn() == -1, "Sell In should be now -1");
	}

}
