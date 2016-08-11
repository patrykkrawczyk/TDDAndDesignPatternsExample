package com.patrykkrawczyk.tdddpexample;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Factory {

    private static Factory instance;
    private int productsProduced;

    public static Factory getInstance() {
        if (instance == null) instance = new Factory();
        return instance;
    }

    private void incrementProductsProduced() {
        ++productsProduced;
    }

    public int getProductsProduced() {
        return productsProduced;
    }

    private Factory() { }

    public Product createProduct(Prototype prototype) {
        if (prototype == null) throw new IllegalArgumentException("Prototype cant be null");

        Product newProduct = new Product();
        incrementProductsProduced();

        return newProduct;
    }

}
