package com.patrykkrawczyk.tdddpexample;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Factory {

    private static Factory mInstance;
    private int mProductsProduced;

    public static Factory getInstance() {
        if (mInstance == null) mInstance = new Factory();
        return mInstance;
    }

    private void incrementProductsProduced() {
        ++mProductsProduced;
    }

    public int getProductsProduced() {
        return mProductsProduced;
    }

    private Factory() { }

    public Product createProduct(Prototype prototype) {
        if (prototype == null) throw new IllegalArgumentException("Prototype cant be null");

        Product newProduct = new Product();
        incrementProductsProduced();

        return newProduct;
    }

}
