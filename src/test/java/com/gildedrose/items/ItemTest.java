package com.gildedrose.items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemTest {
    private Item item;
    @Before
    public void createTestItems() {
        item = new Item("Sulfuras, Hand of Ragnaros", -1, 2);
    }

    @Test
    public void testCreatedObject(){
        assertNotNull(item);
        assertEquals("Sulfuras, Hand of Ragnaros, -1, 2", item.toString());
    }
}
