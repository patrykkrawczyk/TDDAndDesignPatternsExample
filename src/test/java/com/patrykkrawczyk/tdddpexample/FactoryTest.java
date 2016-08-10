package com.patrykkrawczyk.tdddpexample;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class FactoryTest {

    private Factory factory;

    @Before
    public void setUp() throws Exception {
        factory = Factory.getInstance();
    }

    @Test
    public void getInstance_ShouldNotBeNullAndReturnInitializedFactory() throws Exception {
        assertNotNull(factory);
    }

}
