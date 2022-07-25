package com.gildedrose.items;

public class Backstage extends GenericItem{
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateProductDetails() {
        updateDaysLeft();
        updateQuality();
    }

    @Override
    protected void updateQuality() {
        if(quality<50){
            quality++;
        }
        if(sellIn<11 && quality<50){
            quality++;
        }
        if(sellIn<6 && quality<50){
            quality++;
        }
        if(sellIn<0){
            quality=0;
        }
    }
}
