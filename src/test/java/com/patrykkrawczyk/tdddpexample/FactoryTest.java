package com.patrykkrawczyk.tdddpexample;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class FactoryTest {

    private Factory mFactory;
    private Queue<Command> mCommands;

    @Mock
    private Prototype mPrototype;

    @Mock
    private Command mCreateCommandItem1;

    @Mock
    private Command mCreateCommandItem2;

    @Mock
    private Command mCombineCommand;

    @Mock
    private Command mFinishCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mFactory = Factory.getInstance();
        mCommands = new LinkedList<>();

        when(mCreateCommandItem1.getOperation()).thenReturn(Command.Operation.CREATE);
        when(mCreateCommandItem1.getArguments()).thenReturn(new String[]{ "item1" });

        when(mCreateCommandItem2.getOperation()).thenReturn(Command.Operation.CREATE);
        when(mCreateCommandItem2.getArguments()).thenReturn(new String[]{ "item2" });

        when(mCombineCommand.getOperation()).thenReturn(Command.Operation.COMBINE);
        when(mCombineCommand.getArguments()).thenReturn(new String[]{ "item1", "item2", "result" });

        when(mFinishCommand.getOperation()).thenReturn(Command.Operation.FINISH);
        when(mFinishCommand.getArguments()).thenReturn(new String[]{ "result" });

        mCommands.add(mCreateCommandItem1);
        mCommands.add(mCreateCommandItem2);
        mCommands.add(mCombineCommand);
        mCommands.add(mFinishCommand);

        when(mPrototype.getCommands()).thenReturn(mCommands);
    }

    @Test
    public void getInstance_ShouldNotBeNullAndReturnInitializedFactoryObject() {
        assertNotNull(mFactory);
    }

    @Test
    public void createProduct_ShouldNotReturnNull() {
        Product newProduct = mFactory.createProductFromPrototype(mPrototype);
        assertNotNull(newProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProduct_ShouldThrowExceptionForNullArgument() {
        mFactory.createProductFromPrototype(null);
    }

    @Test
    public void getOrdersFinished_shouldReturnAmountOfProductsProducedBasedOnPrototype() {
        int oldSize = mFactory.getFinishedOrdersAmount();
        mFactory.createProductFromPrototype(mPrototype);
        assertEquals(oldSize + 1, mFactory.getFinishedOrdersAmount());
    }

}
