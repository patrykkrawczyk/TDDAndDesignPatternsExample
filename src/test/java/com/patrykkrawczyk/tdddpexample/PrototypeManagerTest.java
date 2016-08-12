package com.patrykkrawczyk.tdddpexample;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public class PrototypeManagerTest {

    private PrototypeManager mPrototypeManager;

    @Before
    public void setUp() {
        mPrototypeManager = PrototypeManager.getInstance();
    }

    @Test
    public void getInstance_shouldNotReturnNull() {
        assertNotNull(PrototypeManager.getInstance());
    }

    @Test
    public void getPrototypesCount_shouldReturnAmountOfPrototypesAvailable() {
        mPrototypeManager.getPrototypesCount();
    }

    @Test
    public void getPrototype_shouldHaveTheSameSizeAsOriginal() {
        List<Prototype> prototypes = mPrototypeManager.getPrototypes();
        assertEquals(prototypes.size(), mPrototypeManager.getPrototypesCount());
    }

    @Test
    public void getPrototype_shouldNotReturnNull() {
        assertNotNull(mPrototypeManager.getPrototypes());
    }

}
