package com.patrykkrawczyk.tdddpexample;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class FactoryTest {

    private final String EXAMPLE_PROTOTYPE_NAME = "EXAMPLE";

    private Factory mFactory;
    private final Prototype prototype = new Prototype(EXAMPLE_PROTOTYPE_NAME);

    @Before
    public void setUp() {
        mFactory = Factory.getInstance();
    }

    @Test
    public void getInstance_ShouldNotBeNullAndReturnInitializedFactoryObject() {
        assertNotNull(mFactory);
    }

    @Test
    public void createProduct_ShouldNotReturnNull() {
        Product newProduct = mFactory.createProductFromPrototype(prototype);
        assertNotNull(newProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProduct_ShouldThrowExceptionForNullArgument() {
        mFactory.createProductFromPrototype(null);
    }

    @Test
    public void getOrdersFinished_shouldReturnAmountOfProductsProducedBasedOnPrototype() {
        int oldSize = mFactory.getFinishedOrdersAmount();
        mFactory.createProductFromPrototype(prototype);
        assertEquals(oldSize + 1, mFactory.getFinishedOrdersAmount());
    }
}
