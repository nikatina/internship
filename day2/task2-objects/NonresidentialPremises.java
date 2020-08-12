package com.sample.object;

public class NonresidentialPremises extends realEstateObject {
    protected String target;
    protected boolean partOfBuilding;

    public NonresidentialPremises(double square, double priceSquareMeter, String target, boolean partOfBuilding){
        super(square, priceSquareMeter);
        this.target = target;
        this.partOfBuilding = partOfBuilding;
    }
}
