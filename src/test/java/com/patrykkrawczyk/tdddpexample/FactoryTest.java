package com.patrykkrawczyk.tdddpexample;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class FactoryTest {

    private Factory factory;
    @Mock
    private Prototype prototype;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        factory = Factory.getInstance();
    }

    @Test
    public void getInstance_ShouldNotBeNullAndReturnInitializedFactoryObject() {
        assertNotNull(factory);
    }

    @Test
    public void getProducedItemCount_returnsNumberGreaterThanZeroDefiningAmountOfProducedObjects() {
        assertTrue(factory.getProductsProduced() >= 0);
    }

    @Test
    public void incrementProductsProduced_AfterIncrementingValueShouldBeIncreased() {
        int amount = factory.getProductsProduced();
        factory.createProduct(prototype);
        assertEquals(amount + 1, factory.getProductsProduced());
    }

    @Test
    public void createProduct_ShouldntReturnNull() {
        Product newProduct = factory.createProduct(prototype);
        assertNotNull(newProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProduct_ShouldThrowExceptionForNullArgument() {
        factory.createProduct(null);
    }
}
