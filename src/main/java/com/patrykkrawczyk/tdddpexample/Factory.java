package com.patrykkrawczyk.tdddpexample;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Factory {

    private static Factory instance = new Factory();
    private int productsProduced;

    public static Factory getInstance() {
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
