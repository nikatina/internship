package com.sample.object;

public class Flat extends LivingQuarters{
    private int floor;

    public Flat(double square, double priceSquareMeter, int rooms, boolean peopleLive, int floor)
    {
        super(square, priceSquareMeter, rooms, peopleLive);
        this.floor = floor;

    }
}
