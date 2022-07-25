package com.gildedrose.handle;

import com.gildedrose.items.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTestFixture {

    @Test
    public void testAfter5Days(){
        List<GenericItem> items = new ArrayList<>();
        items.add(new OtherItem("+5 Dexterity Vest", 10, 20));
        items.add(new AgedBrie("Aged Brie", 2, 0));
        items.add(new OtherItem("Elixir of the Mongoose", 5, 7));
        items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0));
        items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", -1));
        items.add(new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        items.add(new Backstage("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        // this conjured item has been fixed
        items.add(new Conjured("Conjured Mana Cake", 3, 6));

        GildedRose app = new GildedRose(items);

        int days = 5;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            items.forEach(item->{
                System.out.println(item);
            });
            System.out.println();
            app.updateQuality();
        }

        assertEquals(5, items.get(0).sellIn);
        assertEquals(50, items.get(7).quality);
    }

}
