package com.sample.object;


public class ObjectsDemo {
    public static void main(String[] args) {
        LivingQuarters exampleLR = new LivingQuarters(125.7,30000,5,true);
        System.out.println(exampleLR.priceWholeObject);

        Flat exampleFlat = new Flat(70,35000,2,true, 3);
        System.out.println(exampleFlat.priceWholeObject);

        House exampleHouse = new House(100,20000,3,false, 1);
        System.out.println(exampleHouse.priceWholeObject);

        NonresidentialPremises exampleNP = new NonresidentialPremises(1000,1000,"Rent",true);
        System.out.println(exampleNP.priceWholeObject);

        Shop exampleShop = new Shop(200,20604,"",true, "products");
        System.out.println(exampleShop.priceWholeObject);
        System.out.println(exampleShop.target);

    }
}
