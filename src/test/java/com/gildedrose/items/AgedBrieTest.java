package com.gildedrose.items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AgedBrieTest {

    private AgedBrie expiredItem;
    private AgedBrie notExpiredItem;

    @Before
    public void createTestItems() {
        expiredItem = new AgedBrie("Aged Brie", -2, 30);
        notExpiredItem = new AgedBrie("Aged Brie", 5, 30);
    }

    @Test
    public void testUpdateProductDetails() {
        AgedBrie agedBrie = new AgedBrie("Aged Brie", 7, 30);
        agedBrie.updateProductDetails();
        assertEquals(31, agedBrie.quality);
        assertEquals(6, agedBrie.sellIn);
    }

    @Test
    public void updateQualityExpiredProductShouldIncrementQualityBy2() {
        expiredItem.updateQuality();
        assertEquals(32, expiredItem.quality);
    }

    @Test
    public void updateQualityExpiredProductShouldIncrementQualityBy1() {
        notExpiredItem.updateQuality();
        assertEquals(31, notExpiredItem.quality);
    }

    @Test
    public void updateQualityMax50AfterManyIncrements() {
        AgedBrie item = new AgedBrie("Aged Brie", 70, 1);
        for(int i=0; i<100; i++){
            item.updateQuality();
        }
        assertEquals(50, item.quality);
    }

    @Test
    public void testTwoAgedBrieEqual() {
        AgedBrie agedBrie1 = new AgedBrie("Aged Brie", 1, 49);
        AgedBrie agedBrie2 = new AgedBrie("Aged Brie", 1, 49);
        assertEquals(agedBrie1, agedBrie2);
    }

    @Test
    public void testTwoAgedBrieNotEqual() {
        AgedBrie agedBrie1 = new AgedBrie("Aged Brie", 2, 49);
        AgedBrie agedBrie2 = new AgedBrie("Aged Brie", 1, 49);
        assertNotEquals(agedBrie1, agedBrie2);
    }
}
