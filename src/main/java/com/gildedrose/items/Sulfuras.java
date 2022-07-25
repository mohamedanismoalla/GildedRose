package com.gildedrose.items;

public class Sulfuras extends GenericItem {

    private final static int QUALITY = 80;

    public Sulfuras(String name, int sellIn) {
        super(name, sellIn, QUALITY);
    }

    @Override
    public void updateProductDetails() {
    }
}
