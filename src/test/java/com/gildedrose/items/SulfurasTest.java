package com.gildedrose.items;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SulfurasTest {
    private Sulfuras sulfuras;

    @Before
    public void createTestItems() {
        sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0);
    }

    @Test
    public void testCreatedObject(){
        assertNotNull(sulfuras);
        assertEquals(80, sulfuras.quality);
    }

    @Test
    public void updateProductDetails() {
        Sulfuras item = new Sulfuras("Sulfuras, Hand of Ragnaros", 15);
        item.updateProductDetails();
        assertEquals(80, item.quality);
        assertEquals(15, item.sellIn);
    }

    @Test
    public void testTwoSulfurasEqual() {
        Sulfuras item1 = new Sulfuras("Sulfuras, Hand of Ragnaros", 2);
        Sulfuras item2 = new Sulfuras("Sulfuras, Hand of Ragnaros", 2);
        assertEquals(item1, item2);
    }

    @Test
    public void testTwoSulfurasNotEqual() {
        Sulfuras item1 = new Sulfuras("Sulfuras, Hand of Ragnaros", 1);
        Sulfuras item2 = new Sulfuras("Sulfuras, Hand of Ragnaros", 0);
        assertNotEquals(item1, item2);
    }
}
