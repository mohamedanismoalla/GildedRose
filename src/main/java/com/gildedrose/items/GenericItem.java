package com.gildedrose.items;

import java.util.Objects;

public abstract class GenericItem extends Item {

    /*
    This attribute is defining the quality degradation speed,
    it is useful for the case of "Conjured" item that have the same comportment
    as a normal item, just the degradation speed is *2
    */
    protected int degradationIndex;

    public GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        this.degradationIndex = 1;
    }

    public GenericItem(String name, int sellIn, int quality, int degradationIndex) {
        super(name, sellIn, quality);
        this.degradationIndex = degradationIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return degradationIndex == that.degradationIndex && name.equals(that.name) && quality == that.quality && sellIn == that.sellIn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(degradationIndex, name, quality, sellIn);
    }

    //should be public to be shown by the "GildedRoseAnis" class which is outside the package
    public void updateProductDetails() {
        updateDaysLeft();
        updateQuality();
    }

    /*
    protected access is enough because this method can be visible from the sub classes
    via inheritance and Polymorphism
    */
    protected void updateDaysLeft() {
        sellIn--;
    }

    /*
    protected access is enough because this method can be visible from the sub classes
    via inheritance and Polymorphism
    if the product is expired, reduce the quality by 2
    if the product is still not expired, reduce the quality by 1
    */
    protected void updateQuality() {
        quality = (sellIn < 0) ? reduceQuality(2 * degradationIndex) : reduceQuality(1 * degradationIndex);
    }

    /*
    quality should be always >= 0
    if the quality will still remain >= 0 after reduction, reduce it and return it;
    If the quality will be <0 after reduction, set it to 0 and return it
    */
    public int reduceQuality(int valueToBeReduced) {
        return (quality > valueToBeReduced) ? quality - valueToBeReduced : 0;
    }
}
