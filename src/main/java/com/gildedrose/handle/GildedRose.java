package com.gildedrose.handle;

import com.gildedrose.items.GenericItem;

import java.util.List;

public class GildedRose {
    List<GenericItem> items;

    public GildedRose(List<GenericItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(item -> {
            item.updateProductDetails();
        });
    }
}
