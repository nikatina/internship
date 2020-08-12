package com.sample.object;

public class House extends LivingQuarters{
    private int floorCount;

    public House(double square, double priceSquareMeter, int rooms, boolean peopleLive, int floorCount)
    {
        super(square, priceSquareMeter, rooms, peopleLive);
        this.floorCount = floorCount;

    }
}
