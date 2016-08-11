package com.patrykkrawczyk.tdddpexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public class ProductTest {
    private Product product;

    private final String EXAMPLE_NAME = "example";

    @Before
    public void setUp() {
        product = new Product(EXAMPLE_NAME);
    }

    @Test
    public void Product_shouldInitializeObject() {
        assertNotNull(new Product(EXAMPLE_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Product_shouldThrowExceptionIfInitializedWithNullName() {
        new Product(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Product_shouldThrowExceptionIfInitializedWithEmptyName() {
        new Product("");
    }

    @Test
    public void getName_shouldReturnNotNullName() {
        assertNotNull(product.getName());
    }

    @Test
    public void getName_shouldReturnNotEmptyName() {
        assertTrue(product.getName().length() > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPart_shouldThrowExceptionIfArgumentIsNull() {
        product.addPart(null);
    }

    @Test
    public void addPart_shouldProperlyAddPart() {
        int oldSize = this.product.getSize();
        product.addPart(new Product(EXAMPLE_NAME));

        assertEquals(oldSize + 1, product.getSize());
    }

    @Test
    public void getSize_shouldReturnNumberOfParts() {
        assertTrue(product.getSize() >= 0);
    }

    @Test
    public void getPartAt_shouldReturnSamePartAtIndex() {
        Part p = new Product(EXAMPLE_NAME);

        int index = product.addPart(p);
        assertEquals(p, product.getPartAt(index));
    }




}
