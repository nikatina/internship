package com.sample.object;

public class Shop extends NonresidentialPremises{
    protected String goods;

    public Shop(double square, double priceSquareMeter, String target, boolean partOfBuilding, String goods){
        super(square, priceSquareMeter, target, partOfBuilding);
        this.target = "shop";
        this.goods = goods;
    }
}
