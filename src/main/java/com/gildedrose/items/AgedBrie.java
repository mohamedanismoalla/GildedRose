package com.gildedrose.items;

public class AgedBrie extends GenericItem{
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateProductDetails() {
        updateDaysLeft();
        updateQuality();
    }

    /*
    if the product is expired, reduce the quality by 2
    if the product is still not expired, reduce the quality by 1
    */
    @Override
    protected void updateQuality() {
        quality = (sellIn < 0) ? incrementQuality(2) : incrementQuality(1);
    }

    /*
    quality should be always <= 0
    if the quality will still remain <= 50 after addition, return quality+valueToBeAdded;
    If the quality will be >50 after addition, set it to 50 and return it
    */
    private int incrementQuality(int valueToBeAdded) {
        return  (50>quality+valueToBeAdded) ? quality+valueToBeAdded : 50;
    }
}
