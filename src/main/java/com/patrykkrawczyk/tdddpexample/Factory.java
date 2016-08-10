package com.patrykkrawczyk.tdddpexample;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Factory {

    private static Factory instance = new Factory();

    public static Factory getInstance() {
        return instance;
    }

    private Factory() { }
}
