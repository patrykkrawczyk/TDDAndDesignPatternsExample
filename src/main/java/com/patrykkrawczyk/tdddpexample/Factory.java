package com.patrykkrawczyk.tdddpexample;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Factory {

    private static Factory mInstance;
    private int mFinishedOrdersAmount;

    public static Factory getInstance() {
        if (mInstance == null) mInstance = new Factory();
        return mInstance;
    }

    public Product createProductFromPrototype(Prototype prototype) {
        if (prototype == null) throw new IllegalArgumentException("Prototype cant be null");

        /* TODO:
            create warehouse
            stworzyc klase(warehouse, prototype) ktora przetworzy komendy i wypluje obiekt Product
         */
        Product product = new Product(prototype.getName());
        if (product != null) mFinishedOrdersAmount++;

        return product;
    }

    public int getFinishedOrdersAmount() {
        return mFinishedOrdersAmount;
    }

}
