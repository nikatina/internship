package com.sample.object;

public abstract class realEstateObject {

    public double square;
    public double priceSquareMeter;
    public double priceWholeObject;

    public realEstateObject(){}

    protected double getPriceWholeObject(double Square, double priceSquareMeter){
        return Square * priceSquareMeter;
    }

    public realEstateObject(double square, double priceSquareMeter)
    {
        this.square = square;
        this.priceSquareMeter = priceSquareMeter;
        this.priceWholeObject = getPriceWholeObject(square, priceSquareMeter);
    }
}
