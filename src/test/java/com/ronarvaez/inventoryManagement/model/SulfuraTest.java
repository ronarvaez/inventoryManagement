package com.ronarvaez.inventoryManagement.model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SulfuraTest {

	@Test
	public void shouldNotAffectQualityAndSellInIsZero() {
		Sulfura sulfura = new Sulfura(10);
		Assert.isTrue(sulfura.getQuality() == 10, "Sulfura quality is 10");
		Assert.isTrue(sulfura.getSellIn() == 0, "Sulfura sell in is 0");
		sulfura.degrade();
		Assert.isTrue(sulfura.getQuality() == 10, "Sulfura quality still is 10");
		Assert.isTrue(sulfura.getSellIn() == 0, "Sulfura sell in still is 0");
	}
}
