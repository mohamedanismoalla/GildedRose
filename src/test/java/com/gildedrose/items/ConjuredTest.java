package com.gildedrose.items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConjuredTest {
    private Conjured conjured;

    @Before
    public void createTestItems() {
        conjured = new Conjured("Conjured Mana Cake", 3, 6);
    }

    @Test
    public void testCreatedObject(){
        assertNotNull(conjured);
        assertEquals(2, conjured.degradationIndex);
    }
}
