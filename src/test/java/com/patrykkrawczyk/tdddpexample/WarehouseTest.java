package com.patrykkrawczyk.tdddpexample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Patryk Krawczyk on 12.08.2016.
 */
public class WarehouseTest {

    private final String EXAMPLE_PART_NAME = "EXAMPLE";
    private final String EXAMPLE_BAD_PART_NAME = "BAD_EXAMPLE";
    private Warehouse mWarehouse;

    @Mock
    private Part mPart;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mWarehouse = new Warehouse();
    }

    @Test
    public void Warehouse_shouldInitializeObject() {
        assertNotNull(new Warehouse());
    }

    @Test
    public void addPart_shouldProperlyAddPart() {
        assertTrue(mWarehouse.addPart(mPart));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPart_shouldThrowExceptionWhenArgumentIsNull() {
        mWarehouse.addPart(null);
    }

    @Test
    public void retrievePart_shouldReturnNotNullPartWhenArgumentNotNullAndNotEmpty() {
        mWarehouse.addPart(new Product(EXAMPLE_PART_NAME));
        assertNotNull(mWarehouse.retrievePart(EXAMPLE_PART_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrievePart_shouldTrowExcpetionWhenArgumentIsNull() {
        assertNotNull(mWarehouse.retrievePart(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrievePart_shouldTrowExcpetionWhenArgumentIsEmpty() {
        assertNotNull(mWarehouse.retrievePart(""));
    }

    @Test(expected = NoSuchElementException.class)
    public void retrievePart_shouldTrowExcpetionWhenArgumentIsNotPresent() {
        mWarehouse.retrievePart(EXAMPLE_BAD_PART_NAME);
    }

}
