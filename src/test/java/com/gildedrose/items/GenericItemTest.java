package com.gildedrose.items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GenericItemTest {

    private GenericItem genericItem;

    @Before
    public void createTestItems() {
        genericItem = new AgedBrie("+5 Dexterity Vest", 10, 2);
    }

    @Test
    public void updateDaysLeft() {
        genericItem.updateDaysLeft();
        assertEquals(9, genericItem.sellIn);
    }

    @Test
    public void updateProductDetails() {
        GenericItem item = new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        item.updateProductDetails();
        assertEquals(21, item.quality);
        assertEquals(14, item.sellIn);
    }

    @Test
    public void reduceQualityBy1StillPositive() {
        GenericItem otherItem = new OtherItem("+5 Dexterity Vest", 5, 6);
        int newQuality = otherItem.reduceQuality(1);
        assertEquals(5, newQuality);
    }

    @Test
    public void reduceQualityBy2Become0() {
        GenericItem otherItem = new OtherItem("+5 Dexterity Vest", -3, 1);
        int newQuality = otherItem.reduceQuality(2);
        assertEquals(0, newQuality);
    }

    @Test
    public void reduceConjuredQualityBy4IfExpired() {
        GenericItem expiredItem = new Conjured("Conjured Mana Cake", -3, 5);
        expiredItem.updateQuality();
        assertEquals(1, expiredItem.quality);
    }

    @Test
    public void reduceOtherItemQualityBy2IfExpired() {
        GenericItem expiredItem = new OtherItem("+5 Dexterity Vest", -3, 5);
        expiredItem.updateQuality();
        assertEquals(3, expiredItem.quality);
    }

    @Test
    public void testTwoBackstageEqual() {
        GenericItem item1 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        GenericItem item2 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        assertEquals(item1, item2);
    }

    @Test
    public void testTwoConjuredNotEqual() {
        GenericItem item1 = new Backstage("Conjured Mana Cake", 1, 11);
        GenericItem item2 = new Backstage("Conjured Mana Cake", 1, 21);
        assertNotEquals(item1, item2);
    }
}
