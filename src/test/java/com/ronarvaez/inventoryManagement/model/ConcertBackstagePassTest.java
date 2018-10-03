package com.ronarvaez.inventoryManagement.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConcertBackstagePassTest {

	
	@Test
	public void qualityShouldDropToZeroIfConcertPassed() {
		ConcertBackstagePass item = new ConcertBackstagePass(15,0);
		Assert.isTrue(item.getQuality() == 15, "Quality should be 15");
		Assert.isTrue(item.getSellIn() == 0, "Sell In should be 0");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 0, "Quality should be degraded to 0");
		Assert.isTrue(item.getSellIn() == -1, "Sell In should be now -1");
	}
	
	@Test
	public void qualityShouldIncreaseByTwoIfTenDaysorLessForConcert() {
		ConcertBackstagePass item = new ConcertBackstagePass(15,10);
		Assert.isTrue(item.getQuality() == 15, "Quality should be 15");
		Assert.isTrue(item.getSellIn() == 10, "Sell In should be 10");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 17, "Quality should be degraded to 17");
		Assert.isTrue(item.getSellIn() == 9, "Sell In should be now 9");
	}
	
	@Test
	public void qualityShouldIncreaseByOneIfMoreOfTenDaysForConcert() {
		ConcertBackstagePass item = new ConcertBackstagePass(15,11);
		Assert.isTrue(item.getQuality() == 15, "Quality should be 15");
		Assert.isTrue(item.getSellIn() == 11, "Sell In should be 11");
		item.degrade();	
		Assert.isTrue(item.getQuality() == 16, "Quality should be degraded to 16");
		Assert.isTrue(item.getSellIn() == 10, "Sell In should be now 10");
	}
}
