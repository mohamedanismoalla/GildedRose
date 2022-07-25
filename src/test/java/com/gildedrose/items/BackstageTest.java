package com.gildedrose.items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BackstageTest {

    private Backstage backstage1;
    private Backstage backstage2;
    private Backstage backstage3;
    private Backstage backstage4;
    private Backstage backstage5;

    @Before
    public void createTestItems() {
        backstage1 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        backstage2 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        backstage3 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 32);
        backstage4 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 4, 24);
        backstage5 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 4, 48);
    }

    @Test
    public void updateQualityBy1() {
        backstage1.updateQuality();
        assertEquals(21, backstage1.quality);
    }

    @Test
    public void updateQualityBy2() {
        backstage2.updateQuality();
        assertEquals(50, backstage2.quality);
    }

    @Test
    public void updateQualityBy2Max50() {
        backstage3.updateQuality();
        assertEquals(34, backstage3.quality);
    }

    @Test
    public void updateQualityBy3() {
        backstage4.updateQuality();
        assertEquals(27, backstage4.quality);
    }

    @Test
    public void updateQualityBy3Max50() {
        backstage5.updateQuality();
        assertEquals(50, backstage5.quality);
    }

    @Test
    public void updateProductDetails() {
        Backstage item = new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        item.updateProductDetails();
        assertEquals(21, item.quality);
        assertEquals(14, item.sellIn);
    }

    @Test
    public void testTwoBackstageEqual() {
        Backstage item1 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        Backstage item2 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        assertEquals(item1, item2);
    }

    @Test
    public void testTwoBackstageNotEqual() {
        Backstage item1 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        Backstage item2 = new Backstage("Backstage passes to a TAFKAL80ETC concert", 1, 45);
        assertNotEquals(item1, item2);
    }
}
