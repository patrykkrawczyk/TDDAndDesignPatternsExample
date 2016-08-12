package com.patrykkrawczyk.tdddpexample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public class ProductTest {

    private Product mProduct;

    private final String EXAMPLE_NAME = "example";

    @Before
    public void setUp() {
        mProduct = new Product(EXAMPLE_NAME);
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
        assertNotNull(mProduct.getName());
    }

    @Test
    public void getName_shouldReturnNotEmptyName() {
        assertTrue(mProduct.getName().length() > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPart_shouldThrowExceptionIfArgumentIsNull() {
        mProduct.addPart(null);
    }

    @Test
    public void addPart_shouldProperlyAddPart() {
        int oldSize = this.mProduct.getSize();
        mProduct.addPart(new Product(EXAMPLE_NAME));

        assertEquals(oldSize + 1, mProduct.getSize());
    }

    @Test
    public void getSize_shouldReturnNumberOfParts() {
        assertTrue(mProduct.getSize() >= 0);
    }

    @Test
    public void getPartAt_shouldReturnSamePartAtIndex() {
        Part p = new Product(EXAMPLE_NAME);

        int index = mProduct.addPart(p);
        assertEquals(p, mProduct.getPartAt(index));
    }

    @Test
    public void toString_shouldNotReturnNullString() {
        String result = mProduct.toString();
        assertNotNull(result);
    }

    @Test
    public void toString_shouldNotReturnEmptyString() {
        String result = mProduct.toString();
        assertTrue(result.length() > 0);
    }

    @Test
    public void toString_shouldNotReturnNullPointerException() {
        try {
            String result = mProduct.toString();
        } catch (NullPointerException e) {
            fail("Product.toString() threw NullPointerException.");
        }
    }


}
