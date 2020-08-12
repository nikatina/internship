package com.sample.object;

public class LivingQuarters extends realEstateObject {

    protected int rooms;
    protected boolean peopleLive;

    public LivingQuarters(double square, double priceSquareMeter, int rooms, boolean peopleLive){
        super(square, priceSquareMeter);
        this.rooms = rooms;
        this.peopleLive = peopleLive;
    }
}
